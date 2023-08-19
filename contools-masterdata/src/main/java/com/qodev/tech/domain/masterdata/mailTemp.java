package com.qodev.tech.domain.masterdata;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
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
    private Integer createdBy;
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private Integer updatedBy;

    public String getMailTempId() {
        return this.mailTempId;
    }

    public void setMailTempId(String mailTempId) {
        this.mailTempId = mailTempId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getMailTempName() {
        return this.mailTempName;
    }

    public void setMailTempName(String mailTempName) {
        this.mailTempName = mailTempName;
    }

    public Integer getMailTempStatus() {
        return this.mailTempStatus;
    }

    public void setMailTempStatus(Integer mailTempStatus) {
        this.mailTempStatus = mailTempStatus;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getMailTempDomain() {
        return mailTempDomain;
    }

    public void setMailTempDomain(String mailTempDomain) {
        this.mailTempDomain = mailTempDomain;
    }
}
