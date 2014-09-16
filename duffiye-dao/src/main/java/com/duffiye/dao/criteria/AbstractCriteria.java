package com.duffiye.dao.criteria;
import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class AbstractCriteria {
    private Long id;
    private String keyword;
    // 判断是否通过ajax方式调用数据,如果是ajax调整用数据,需要过滤循环关系数据引用
    private boolean isAjax = false;
    // 深度加载数据,及是否加载所有关联对象数据.一般情况只有loadById才深度加载数据,否则,只加载当前对应表数据. 
    private boolean deep=false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public boolean isAjax() {
        return isAjax;
    }

    public void setAjax(boolean isAjax) {
        this.isAjax = isAjax;
    }

    public boolean isDeep() {
        return deep;
    }

    public void setDeep(boolean deep) {
        this.deep = deep;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
