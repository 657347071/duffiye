package com.duffiye.sys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.duffiye.dao.common.Paginator;
import com.duffiye.dao.impl.jpa.AbstractDAO;
import com.duffiye.dao.utils.HQLHelper;
import com.duffiye.sys.criteria.BasicCriteria;
import com.duffiye.sys.dao.interfaces.IAuthorityDAO;
import com.duffiye.sys.entity.Authority;



@Repository
public class AuthorityDAO extends AbstractDAO<Authority> implements IAuthorityDAO {

    @Override
    public List<Authority> list() {
        return find("from Authority order by parent.id,sequence");
    }

    @Override
    public List<Authority> findByCriteria(BasicCriteria criteria, Paginator paginator) {
        StringBuffer buf = new StringBuffer("select t from Authority t ");
        List<String> names = new ArrayList<String>();
        List<Object> params = new ArrayList<Object>();
        if (criteria != null) {
            String keyword = criteria.getKeyword();
            if (StringUtils.isNotBlank(keyword)) {
                String str = "%" + StringUtils.trimToEmpty(keyword) + "%";
                HQLHelper.appendAndToWhereClause(buf);
                buf.append(" ( code like :code or name like :name)");
                names.add("code");
                names.add("name");
                params.add(str);
                params.add(str);
            }
        }
        if (paginator != null && StringUtils.isBlank(paginator.getSort())) {
            paginator.setSort("parent.id,sequence");
        }
        return find(buf, names, params, paginator);
    }

}
