package com.duffiye.sys.service.assembler;

import com.duffiye.core.service.assembler.AbstractAssembler;
import com.duffiye.sys.dto.RoleDTO;
import com.duffiye.sys.entity.Role;

public class RoleAssembler extends AbstractAssembler<RoleDTO, Role> {

    @Override
    protected void toDTO(RoleDTO dto, Role model, boolean deep, boolean isAjax) {
        if (deep) {
            dto.setAuthorities(getAssembler(AuthorityAssembler.class).toDTOList(model.getAuthorities()));
        }
    }

}
