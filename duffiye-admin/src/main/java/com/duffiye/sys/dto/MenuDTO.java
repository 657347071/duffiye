package com.duffiye.sys.dto;

import org.apache.commons.lang.StringUtils;

import com.duffiye.dao.dto.IdDTO;

public class MenuDTO extends IdDTO {
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
     *sort 排序
     */
    private Integer sequence;
   

   

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHref() {
        return StringUtils.isBlank(href) ? url : href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

 

}
