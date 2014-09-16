package com.duffiye.core.service;

import java.io.Serializable;
import java.util.List;

import com.duffiye.dao.common.Paginator;
import com.duffiye.dao.dto.IdDTO;



public interface IServer<T extends IdDTO> {
    public T saveOrUpdate(T dto);

    public Boolean delete(Serializable id);

    public T loadById(java.io.Serializable id);

    public List<T> list();

    public List<T> list(Paginator paginator);

}
