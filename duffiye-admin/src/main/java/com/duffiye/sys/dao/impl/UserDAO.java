package com.duffiye.sys.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.duffiye.dao.common.Paginator;
import com.duffiye.dao.impl.jpa.AbstractDAO;
import com.duffiye.sys.criteria.UserCriteria;
import com.duffiye.sys.dao.interfaces.IUserDAO;
import com.duffiye.sys.entity.User;



@Repository
public class UserDAO extends AbstractDAO<User> implements IUserDAO {

    public List<User> findByLoginName(String loginName) {
        return find("select t from User t where t.loginName=?", loginName);
    }

    @Override
    public List<User> findByCriteria(UserCriteria criteria, Paginator paginator) {
        StringBuffer buf = new StringBuffer("select t from User t ");
        List<String> names = new ArrayList<String>();
        List<Object> params = new ArrayList<Object>();
        return find(buf, names, params, paginator);
    }

}
