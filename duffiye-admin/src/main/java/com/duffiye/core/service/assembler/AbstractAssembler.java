package com.duffiye.core.service.assembler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.duffiye.core.service.IAssembler;
import com.duffiye.core.utils.DateUtils;
import com.duffiye.dao.dto.IdDTO;
import com.duffiye.dao.entity.IEntity;


public abstract class AbstractAssembler<T extends IdDTO, M extends IEntity<Long>> implements IAssembler<T, M> {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected Class<T> clzT;
    protected Class<M> clzM;
    private Map<Long, T> cache;

    @SuppressWarnings("unchecked")
    public AbstractAssembler() {
        clzT = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        clzM = (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        cache = new HashMap<Long, T>(5);
    }

    public M newModel() {
        return BeanUtils.instantiate(clzM);
    }

    public T newDTO() {
        return BeanUtils.instantiate(clzT);
    }

    public T toDTO(M model) {
        return toDTO(model, false);
    }

    @Override
    public T toDTO(M model, boolean deep) {
        return toDTO(model, deep, false);
    }

    public T toDTO(M model, boolean deep, boolean isAjax) {
        if (model == null) {
            return newDTO();
        }
        final Long key = (Long) model.getId();
        if (!cache.containsKey(key) || cache.get(key) == null) {
            T dto = newDTO();
            //put to cache
            cache.put(key, dto);
            //same property 
            initSameProperty(model, dto);
            //opertion
            toDTO(dto, model, deep, isAjax);
        }
        if (logger.isDebugEnabled() && cache.get(key) == null) {
            logger.debug(clzM + "model is " + ToStringBuilder.reflectionToString(model));
            logger.debug(clzT + " id = " + key + " is null");
        }
        return cache.get(key);
    }

    @Override
    public void toModel(M target, T source) {
        //same property 
        initSameProperty(source, target);
        //转化其它属生
        convertModel(target, source);
    }

    /** 
     * 设置两个相同名称属性的
    * @param source
    * @param target
    */
    protected void initSameProperty(Object source, Object target) {
        PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(source.getClass());
        Map<String, PropertyDescriptor> modelMap = new HashMap<String, PropertyDescriptor>();
        for (PropertyDescriptor pd : pds) {
            String key = pd.getName();
            if ("class".equalsIgnoreCase(key)) {
                continue;
            }
            modelMap.put(key, pd);
        }
        PropertyDescriptor[] descriptors = BeanUtils.getPropertyDescriptors(target.getClass());
        for (PropertyDescriptor pd : descriptors) {
            String key = pd.getName();
            Class<?> targetType = pd.getPropertyType();
            PropertyDescriptor comp = modelMap.get(key);
            try {
                if (comp != null && BeanUtils.isSimpleProperty(targetType)) {
                    Object value = comp.getReadMethod().invoke(source);
                    if (value == null) {
                        continue;
                    }
                    if (value instanceof String) {
                        final String str = (String) value;
                        if (StringUtils.isBlank(str)) {
                            continue;
                        } else {
                            value = StringUtils.trimToEmpty(str);
                        }
                    }
                    final Class<?> sourceType = comp.getPropertyType();
                    final Method writeMethod = pd.getWriteMethod();
                    if (targetType.equals(sourceType)) {
                        writeMethod.invoke(target, value);
                    } else if (java.sql.Date.class.equals(sourceType) && String.class.equals(targetType)) {
                        String sdate = DateUtils.formatDate((java.util.Date) value);
                        writeMethod.invoke(target, sdate);
                    } else if (Timestamp.class.equals(sourceType) && String.class.equals(targetType)) {
                        String sdatetime = DateUtils.formatSDate((java.util.Date) value);
                        writeMethod.invoke(target, sdatetime);
                    } else if (Time.class.equals(sourceType) && String.class.equals(targetType)) {
                        String stime = DateUtils.formatTime((java.util.Date) value);
                        writeMethod.invoke(target, stime);
                    } else if (String.class.equals(sourceType) && java.sql.Date.class.equals(targetType)) {
                        java.sql.Date date = DateUtils.toDate((String) value);
                        writeMethod.invoke(target, date);
                    } else if (String.class.equals(sourceType) && Timestamp.class.equals(targetType)) {
                        Timestamp dateTime = DateUtils.toDateTime((String) value);
                        writeMethod.invoke(target, dateTime);
                    } else if (String.class.equals(sourceType) && Time.class.equals(targetType)) {
                        Time time = DateUtils.toTime((String) value);
                        writeMethod.invoke(target, time);
                    }
                }
            } catch (Exception e) {
                //do nothing
            }
        }
    }

    @Override
    public List<T> toDTOList(Collection<M> coll) {
        return toDTOList(coll, false);
    }

    @Override
    public List<T> toDTOList(Collection<M> coll, boolean deep) {
        return toDTOList(coll, deep, false);
    }

    @Override
    public List<T> toDTOList(Collection<M> coll, boolean deep, boolean isAjax) {
        if (CollectionUtils.isEmpty(coll)) {
            return new ArrayList<T>(0);
        }
        List<T> result = new ArrayList<T>(coll.size());
        for (M model : coll) {
            result.add(toDTO(model, deep, isAjax));
        }
        return result;
    }

    protected static <T> T getAssembler(Class<T> type) {
        return AssemblerMananger.getAssembler(type);
    }

    protected void convertModel(M model, T dto) {
    };

    protected abstract void toDTO(T dto, M model, boolean deep, boolean isAjax);

    @Override
    public void cleanCache() {
        cache.clear();
    }
}
