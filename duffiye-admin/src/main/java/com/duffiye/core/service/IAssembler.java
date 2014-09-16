package com.duffiye.core.service;

import java.util.Collection;
import java.util.List;

import com.duffiye.dao.dto.IdDTO;
import com.duffiye.dao.entity.IdEntity;


public interface IAssembler<T extends IdDTO, M extends IdEntity> {
    M newModel();

    T newDTO();

    T toDTO(M model);

    T toDTO(M model, boolean deep);

    T toDTO(M model, boolean deep, boolean isAjax);

    List<T> toDTOList(Collection<M> coll);

    List<T> toDTOList(Collection<M> coll, boolean deep);

    List<T> toDTOList(Collection<M> coll, boolean deep, boolean isAjax);

    void toModel(M model, T dto);

    void cleanCache();

}
