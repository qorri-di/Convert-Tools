package com.qodev.tech.dto.response.role;

import com.qodev.tech.domain.masterdata.role;

import java.util.List;

public class roleSearchResponse {
    private List<role> search;
    private Integer page;
    private Integer size;
    private Integer totalPage;
    private Integer totalData;

    public List<role> getSearch() {
        return search;
    }

    public void setSearch(List<role> search) {
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

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalData() {
        return totalData;
    }

    public void setTotalData(Integer totalData) {
        this.totalData = totalData;
    }
}
