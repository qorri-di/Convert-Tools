package com.qodev.tech.dto.response.mail;

import com.qodev.tech.domain.masterdata.mailTemp;

import java.util.*;

public class mailTempSearchResponse {
    private List<mailTemp> search;
    private Integer page;
    private Integer size;
    private Integer totalPage;
    private Integer totalData;

    public List<mailTemp> getSearch() {
        return search;
    }

    public void setSearch(List<mailTemp> search) {
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
