package com.luobo.util;

import java.util.List;

/**
 * @author:ws
 */

public class Page<T> {
    /**
     *  其中currentPage,perPageRows这两个参数是做分页查询必须具备的参数
     *  原因是：hibernate中的Criteria或则是Query这两个接口：都有setFirstResult(Integer firstResult)
     *  和setMaxResult(Integer maxResult),
     *  这里的firstResult就是每页的开始的索引数：
     *  每页开始的索引数的计算公式是：（currentPage-1）*perPageRows+1,(这是相对索引从1开始的)
     *  但是Hibernate中的firstResult的索引是从0开始的，所以在hibernate中每页开始的索引数的计算公式是：
     *  (currentPage-1)*perPageRows+1-1=(currentPge-1)*perPageRows.
     *
     *  maxResult就是每页能查询的最大记录数：也就是perPageRows.
     *
     *  Math.ceil(totalRows/perPageRows)==totalPages;//这是根据总记录数和每页的记录数算出总页数的计算公式。
     */
    private Integer pageIndex;//当前页
    private Integer pageSize;//每页的记录数
    private Integer total;//总记录数：
    private long totalPages;//总页数：
    private List<T> elements;

    public Page(Integer pageIndex, Integer pageSize, Integer total, List<T> elements) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
        this.elements = elements;
        double a = (double) total / pageSize;
        totalPages = Math.round(Math.ceil(a));
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}