package com.duffiye.dao.common;

public class Paginator {
    // number of total records
    private Integer totalRecords;
    // the current page
    private int pageIndex = 1;
    // number of records on current page
    private int pageSize = Integer.valueOf(10);
    // the sorted column 
    private String sort;
    // direction of sorted column
    private String dir;
    // 
    private String alias;

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @return the sort
     */
    public String getSort() {
        return sort;
    }

    /**
     * @param sort the sort to set
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * @return the dir
     */
    public String getDir() {
        return dir;
    }

    /**
     * @param dir the dir to set
     */
    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     * @return the totalRecords
     */
    public Integer getTotalRecords() {
        return totalRecords;
    }

    /** 
    * @return total page
    */
    public Integer getTotalPage() {
        int totalPage = totalRecords / pageSize;
        int mod = totalRecords % pageSize;
        return totalPage + (mod == 0 ? 0 : 1);
    }

    /**
     * @param totalRecords the totalRecords to set
     */
    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    /**
     * @return the startIndex
     */
    public int getStartIndex() {
        return (this.pageIndex - 1) * pageSize;
    }

    /** 
    * @return the endIndex
    */
    public int getEndIndex() {
        int end = this.pageIndex * pageSize;
        return end > totalRecords ? totalRecords : end;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

}
