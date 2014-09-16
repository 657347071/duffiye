package com.duffiye.core.service;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.duffiye.core.utils.NumberUtils;
import com.duffiye.core.utils.SecurityUtils;
import com.duffiye.sys.dao.interfaces.IUserDAO;
import com.duffiye.sys.dto.UserDTO;
import com.duffiye.sys.entity.User;



public abstract class BaseServer {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    private ThreadLocal<User> operation;
    @Autowired
    protected IUserDAO userDAO;

    public BaseServer() {
        operation = new ThreadLocal<User>();
    }

    protected Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    protected User getOperation() {
        if (operation.get() == null) {
            UserDTO userDTO = SecurityUtils.currentUser();
            Long uid = null == userDTO ? null : userDTO.getId();
            if (NumberUtils.isNotEmpty(uid)) {
                operation.set(userDAO.load(uid));
            }
        }
        return operation.get();
    }
}
