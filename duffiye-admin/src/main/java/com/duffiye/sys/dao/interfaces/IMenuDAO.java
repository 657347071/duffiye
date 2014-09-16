package com.duffiye.sys.dao.interfaces;

import java.util.List;

import com.duffiye.dao.IGenericDAO;
import com.duffiye.dao.common.Paginator;
import com.duffiye.sys.criteria.MenuCriteria;
import com.duffiye.sys.entity.Menu;



public interface IMenuDAO extends IGenericDAO<Menu> {

    List<Menu> listByParentId(Long id);

    /** 
    * @param criteria
    * @param paginator
    * @return
    */
    List<Menu> findByCriteria(MenuCriteria criteria, Paginator paginator);

}
