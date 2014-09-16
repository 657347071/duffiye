package com.duffiye.core.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import com.duffiye.core.service.assembler.AssemblerMananger;
import com.duffiye.core.service.exception.ServerException;
import com.duffiye.core.utils.NumberUtils;
import com.duffiye.dao.IGenericDAO;
import com.duffiye.dao.common.Paginator;
import com.duffiye.dao.dto.IdDTO;
import com.duffiye.dao.entity.IEntity;
import com.duffiye.sys.dao.interfaces.IUserDAO;
import com.duffiye.sys.dto.UserDTO;
import com.duffiye.sys.entity.User;



@Transactional
@SuppressWarnings("unchecked")
public abstract class AbstractServer<T extends IdDTO, M extends IEntity<Long>, A extends IAssembler<T, M>> implements IServer<T> {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    private Class<IAssembler<T, M>> assembler;
    private ThreadLocal<User> operation;
    @Autowired
    protected IUserDAO userDAO;

   

    public AbstractServer() {
        final Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
        assembler = (Class<IAssembler<T, M>>) type;
        operation = new ThreadLocal<User>();
    }

    @Override
    public T saveOrUpdate(T dto) {
        IGenericDAO<M> dao = getGenericDAO();
        final Long id = dto.getId();
        final boolean isNew = null == id;
        M model = isNew ? getAssembler().newModel() : dao.load(id);
        if (null == model) {
            throw new ServerException("load data failed!");
        }
        buildData(model, dto, isNew);
        if (isNew) {
            dao.create(model);
            dto.setId((Long)model.getId());
        } else {
            dao.update(model);
        }
        return dto;
    }

    @Override
    public Boolean delete(Serializable id) {
        IGenericDAO<M> dao = getGenericDAO();
        M model = dao.load(id);
        if (null == model) {
            return Boolean.FALSE;
        }
        dao.delete(model);
        return Boolean.TRUE;
    }

    @Transactional(readOnly = true)
    @Override
    public T loadById(Serializable id) {
        IGenericDAO<M> dao = getGenericDAO();
        M model = dao.load(id);
        return toDTO(model);
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> list() {
        List<M> list = getGenericDAO().list();
        return toDTOList(list);
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> list(Paginator paginator) {
        List<M> list = getGenericDAO().list(paginator);
        return toDTOList(list);
    }

    protected List<T> toDTOList(java.util.Collection<M> coll) {
        return toDTOList(coll, false);
    }

    protected List<T> toDTOList(java.util.Collection<M> coll, boolean deep) {
        return toDTOList(coll, deep, false);
    }

    protected List<T> toDTOList(java.util.Collection<M> coll, boolean deep, boolean isAjax) {
        final List<T> result = getAssembler().toDTOList(coll, deep, isAjax);
        return result;
    }

    protected Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    protected User getOperation() {
        if (operation.get() == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Object obj = auth == null ? null : auth.getPrincipal();
            Long uid = obj instanceof UserDTO ? ((UserDTO) obj).getId() : null;
            if (NumberUtils.isNotEmpty(uid)) {
                operation.set(userDAO.load(uid));
            }
        }
        return operation.get();
    }

    protected T toDTO(M model) {
        return getAssembler().toDTO(model, true);
    }

    protected void buildData(M model, T dto, boolean isNew) {
        getAssembler().toModel(model, dto);
        if (model instanceof IEntity) {
            IEntity<Long> entity = (IEntity<Long>) model;
         //   entity.setOperation(getOperation());
          //  entity.setOperTime(getCurrentTime());
        }
    }

    protected IAssembler<T, M> getAssembler() {
        return AssemblerMananger.getAssembler(assembler);
    }

    protected abstract IGenericDAO<M> getGenericDAO();

}
