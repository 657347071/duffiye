package com.duffiye.sys.dao.impl;

import org.springframework.stereotype.Repository;

import com.duffiye.dao.impl.jpa.AbstractDAO;
import com.duffiye.sys.dao.interfaces.IRoleDAO;
import com.duffiye.sys.entity.Role;



@Repository
public class RoleDAO extends AbstractDAO<Role> implements IRoleDAO {

}