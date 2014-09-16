package com.duffiye.sys.service.assembler;

import com.duffiye.core.service.assembler.AbstractAssembler;
import com.duffiye.sys.dto.AuthorityDTO;
import com.duffiye.sys.entity.Authority;

public class AuthorityAssembler extends AbstractAssembler<AuthorityDTO, Authority> {
    @Override
    protected void toDTO(AuthorityDTO dto, Authority model, boolean deep, boolean isAjax) {
        Authority parent = model.getParent();
        if (parent != null) {
          //  dto.setParent(toDTO(parent, deep));
        }
    }
}