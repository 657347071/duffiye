package com.duffiye.sys.dto;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.duffiye.dao.dto.IdDTO;


public class UserDTO extends IdDTO implements UserDetails {
    /** 
    *serialVersionUID 
    */
    private static final long serialVersionUID = 1L;
    //登陆名
    private String loginName;
    //密码
    private String password;
    //重复密码
    private String rePassword;

    //注册时间
    private String registerTime;
    //最后登陆时间
    private String lastLoginTime;
    //最后更新时间
    private String lastUpdateTime;
    /** 
    *active 是否可用
    */
    private Boolean active;

    /** 
     *roleIds 角色ID列表
     */
    private Long[] roleIds;

    /** 
    *roles 角色集
    */
    private Collection<RoleDTO> roles;
    //权限集
    private Collection<GrantedAuthority> authorities;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active == null ? false : active;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long[] getRoleIds() {
        if (roleIds == null && CollectionUtils.isNotEmpty(roles)) {
            roleIds = new Long[roles.size()];
            int i = 0;
            Iterator<RoleDTO> it = roles.iterator();
            while (it.hasNext()) {
                roleIds[i] = it.next().getId();
                i++;
            }
        }
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public Collection<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleDTO> roles) {
        this.roles = roles;
    }

    @Override
    public String getUsername() {
        return this.loginName;
    }

}
