package com.duffiye.sys.criteria;

import com.duffiye.dao.criteria.AbstractCriteria;


public class MenuCriteria extends AbstractCriteria {

    private Long parentId;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

}
