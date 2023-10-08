package com.qodev.tech.domain.masterdata;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_mail_temp")
public class mailTemp extends PanacheEntityBase {
    @Id
    @Column(name = "mailTemp_id")
    private String mailTempId;

    @Column(name = "mailTemp_name")
    private String mailTempName;

    @Column(name = "mailTemp_domain")
    private String mailTempDomain;

    @Column(name = "mailTemp_status")
    private Integer mailTempStatus;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    public String getMailTempId() {
        return mailTempId;
    }

    public void setMailTempId(String mailTempId) {
        this.mailTempId = mailTempId;
    }

    public String getMailTempName() {
        return mailTempName;
    }

    public void setMailTempName(String mailTempName) {
        this.mailTempName = mailTempName;
    }

    public String getMailTempDomain() {
        return mailTempDomain;
    }

    public void setMailTempDomain(String mailTempDomain) {
        this.mailTempDomain = mailTempDomain;
    }

    public Integer getMailTempStatus() {
        return mailTempStatus;
    }

    public void setMailTempStatus(Integer mailTempStatus) {
        this.mailTempStatus = mailTempStatus;
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
