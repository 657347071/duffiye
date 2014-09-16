package com.duffiye.sys.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.duffiye.dao.entity.IEntity;




/** 
* 菜单,支持无限级
* 类名称：Menu 
* 创建人：duffiye
* @version 
* 
*/
@Entity
@Table(name = "t_sys_menu")
public class Menu implements IEntity<Long> {
	
	private Long id;
    /** 
    *text 显示文字 
    */
    private String text;
    /** 
    *url 链接
    */
    private String url;
    /** 
    *href 
    */
    private String href;
    /** 
    *parent 父菜单
    */
    private Menu parent;

    /** 
    *children 子菜单
    */
    private List<Menu> children;

    /** 
    *sequence 排序
    */
    private Integer sequence = Integer.valueOf(0);

    /** 
    *type 链接类型  navTab dialog
    */
    private String target;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@GeneratedValue(generator = "system-uuid")
    //@GenericGenerator(name = "system-uuid", strategy = "uuid")
    public Long getId() {
        return id;
    }

    @Column(length = 128)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Column
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @Column(length = 24)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @OneToMany(mappedBy = "parent")
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id")
    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

}
