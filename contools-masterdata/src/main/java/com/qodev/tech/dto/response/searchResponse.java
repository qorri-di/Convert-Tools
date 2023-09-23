package com.qodev.tech.dto.response;

public class searchResponse<T> {
    private T search;
    private Integer page;
    private Integer size;
    private Integer total_Page;
    private Integer total_Data;

    public T getSearch() {
        return search;
    }

    public void setSearch(T search) {
        this.search = search;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal_Page() {
        return total_Page;
    }

    public void setTotal_Page(Integer total_Page) {
        this.total_Page = total_Page;
    }

    public Integer getTotal_Data() {
        return total_Data;
    }

    public void setTotal_Data(Integer total_Data) {
        this.total_Data = total_Data;
    }
}
