package com.duffiye.sys.service.assembler;

import com.duffiye.core.service.assembler.AbstractAssembler;
import com.duffiye.sys.dto.UserDTO;
import com.duffiye.sys.entity.User;

public class UserAssembler extends AbstractAssembler<UserDTO, User> {

    @Override
    protected void toDTO(UserDTO dto, User model, boolean deep, boolean isAjax) {
        if (deep) {
            dto.setRoles(getAssembler(RoleAssembler.class).toDTOList(model.getRoles()));
        }
    }

}
