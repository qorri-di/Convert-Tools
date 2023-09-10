package com.qodev.tech.domain.masterdata;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_visibility")
public class visibility {
    @Id
    @Column(name = "id_visibility")
    private String visibilityId;

    @Column(name = "name_visibility")
    private String nameVisibility;

    @Column(name = "status_visibility")
    private Integer statusVisibility;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    public String getVisibilityId() {
        return visibilityId;
    }

    public void setVisibilityId(String visibilityId) {
        this.visibilityId = visibilityId;
    }

    public String getNameVisibility() {
        return nameVisibility;
    }

    public void setNameVisibility(String nameVisibility) {
        this.nameVisibility = nameVisibility;
    }

    public Integer getStatusVisibility() {
        return statusVisibility;
    }

    public void setStatusVisibility(Integer statusVisibility) {
        this.statusVisibility = statusVisibility;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
