package com.duffiye.sys.dao.interfaces;

import java.util.List;

import com.duffiye.dao.IGenericDAO;
import com.duffiye.dao.common.Paginator;
import com.duffiye.sys.criteria.BasicCriteria;
import com.duffiye.sys.entity.Authority;



public interface IAuthorityDAO extends IGenericDAO<Authority> {

    List<Authority> findByCriteria(BasicCriteria criteria, Paginator paginator);

}
