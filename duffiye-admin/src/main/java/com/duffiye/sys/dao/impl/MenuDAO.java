package com.duffiye.sys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.duffiye.core.utils.NumberUtils;
import com.duffiye.dao.common.Paginator;
import com.duffiye.dao.impl.jpa.AbstractDAO;
import com.duffiye.dao.utils.HQLHelper;
import com.duffiye.sys.criteria.MenuCriteria;
import com.duffiye.sys.dao.interfaces.IMenuDAO;
import com.duffiye.sys.entity.Menu;



@Repository
public class MenuDAO extends AbstractDAO<Menu> implements IMenuDAO {

    @Override
    public List<Menu> list() {
        return find("select t from Menu t order by t.parent.id,sequence");
    }

    @Override
    public List<Menu> listByParentId(Long id) {
        if (id == null || id == 0) {
            return find("select t from Menu t where t.parent is null order by t.parent.id,sequence");
        } else {
            return find("select t from Menu t where  t.parent.id=? order by t.parent.id,sequence", id);
        }
    }

    @Override
    public List<Menu> findByCriteria(MenuCriteria criteria, Paginator paginator) {
        StringBuffer buf = new StringBuffer("select t from Menu t");
        List<Object> params = new ArrayList<Object>();
        List<String> names = new ArrayList<String>();
        if (criteria != null) {
            String keyword = criteria.getKeyword();
            if (StringUtils.isNotBlank(keyword)) {
                HQLHelper.appendAndToWhereClause(buf);
                String str = "%" + StringUtils.trimToEmpty(keyword) + "%";
                buf.append(" t.text like :text");
                names.add("text");
                params.add(str);
            }
            Long parentId = criteria.getParentId();
            if (NumberUtils.isNotEmpty(parentId)) {
                HQLHelper.appendAndToWhereClause(buf);
                buf.append(" t.parent.id = :pid");
                names.add("pid");
                params.add(parentId);
            }
        }
        if (null != paginator && StringUtils.isBlank(paginator.getSort())) {
            paginator.setSort("parent.id,sequence");
            paginator.setAlias("t");
        }
        return find(buf.toString(), names.toArray(new String[names.size()]), params.toArray(), paginator);
    }

}
