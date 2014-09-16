package com.duffiye.sys.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.duffiye.dao.entity.IEntity;


/** 
* 类名称：Role 
* 类描述：角色只定义权限 
* 创建人：duffiye
* @version 
* 
*/
@Entity
@Table(name = "t_sys_role")
public class Role implements IEntity<Long> {

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
    *authorities 权限 
    */
    private Set<Authority> authorities;

    /** 
    *users 用户
    */
    private Set<User> users;
    
    private Long id;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@GeneratedValue(generator = "system-uuid")
    //@GenericGenerator(name = "system-uuid", strategy = "uuid")
    public Long getId() {
        return id;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 24)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany
    @JoinTable(name = "t_sys_role_authority", joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "authority_id", referencedColumnName = "id") })
    
    @Fetch(FetchMode.SUBSELECT)
    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @ManyToMany
    @JoinTable(name = "t_sys_role_user", joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") })
    
    @Fetch(FetchMode.SUBSELECT)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

}
