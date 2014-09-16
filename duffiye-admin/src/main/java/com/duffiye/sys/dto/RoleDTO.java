package com.duffiye.sys.dto;

import java.util.Collection;
import java.util.Iterator;

import com.duffiye.dao.dto.IdDTO;


public class RoleDTO extends IdDTO {
    /** 
     *name 名称
     */
    private String name;
    /** 
    *code 编码
    */
    private String code;

    /** 
    *description 描述
    */
    private String description;

    /** 
     * 权限ID
    *authoritiyIds 
    */
    private Long[] authoritiyIds;
    /** 
    *authorities 权限 
    */
    private Collection<AuthorityDTO> authorities;

    /** 
    *users 用户列表
    */
    private Collection<UserDTO> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long[] getAuthoritiyIds() {
        if (authoritiyIds == null && authorities != null) {
            authoritiyIds = new Long[authorities.size()];
            Iterator<AuthorityDTO> it = authorities.iterator();
            int i = 0;
            while (it.hasNext()) {
                authoritiyIds[i] = it.next().getId();
                i++;
            }

        }
        return authoritiyIds;
    }

    public void setAuthoritiyIds(Long[] authoritiyIds) {
        this.authoritiyIds = authoritiyIds;
    }

    public Collection<AuthorityDTO> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<AuthorityDTO> authorities) {
        this.authorities = authorities;
    }

    public Collection<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserDTO> users) {
        this.users = users;
    }
}
