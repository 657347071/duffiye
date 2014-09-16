package com.duffiye.sys.dao.interfaces;

import java.util.List;

import com.duffiye.dao.IGenericDAO;
import com.duffiye.dao.common.Paginator;
import com.duffiye.sys.criteria.UserCriteria;
import com.duffiye.sys.entity.User;



public interface IUserDAO extends IGenericDAO<User> {

    List<User> findByLoginName(String loginName);

    List<User> findByCriteria(UserCriteria criteria, Paginator paginator);

}
