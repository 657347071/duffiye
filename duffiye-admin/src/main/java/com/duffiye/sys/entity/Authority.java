package com.duffiye.sys.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.duffiye.dao.entity.IEntity;



/** 
* 权限实体
* 类名称：Authority 
* 创建人：Duffiye
* 修改备注： 
* @version 
* 
*/
@Entity
@Table(name = "t_sys_authority")
public class Authority implements IEntity<Long> {

    /** 
    *serialVersionUID 
    */
    private static final long serialVersionUID = 1L;
    /** 
    *code 编码
    */
    private String code;
    /** 
    *name 名称
    */
    private String name;
    /** 
    *sequence 排序
    */
    private Integer sequence = Integer.valueOf(0);
    /** 
    *updateTime 手动更新时间
    */
    private Timestamp updateTime;
    /** 
    *roles 角色 
    */
    private Set<Role> roles;
    /** 
     *parent 上级权限
     */
    private Authority parent;

    /** 
    *children 子权限
    */
    private List<Authority> children = new ArrayList<Authority>();
    
    private Long id;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@GeneratedValue(generator = "system-uuid")
    //@GenericGenerator(name = "system-uuid", strategy = "uuid")
    public Long getId() {
        return id;
    }

    @Column(unique = true, nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Column(name="update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Authority getParent() {
        return parent;
    }

    public void setParent(Authority parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent")
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("sequence")
    public List<Authority> getChildren() {
        return children;
    }

    public void setChildren(List<Authority> children) {
        this.children = children;
    }

    @ManyToMany
    @JoinTable(name = "t_sys_role_authority", joinColumns = { @JoinColumn(name = "authority_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
    
    @Fetch(FetchMode.SUBSELECT)
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    public void setId(Long id) {
        this.id = id;
    }


}
