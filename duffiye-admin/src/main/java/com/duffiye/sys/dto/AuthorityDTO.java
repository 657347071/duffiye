package com.duffiye.sys.dto;

import com.duffiye.dao.dto.IdDTO;

public class AuthorityDTO extends IdDTO {
    /** 
     *code 编码
     */
    private String code;
    /** 
    *name 名称
    */
    private String name;
    //排序
    private Integer sequence;
    /** 
    *updateTime 手动更新时间
    */
    private String updateTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
