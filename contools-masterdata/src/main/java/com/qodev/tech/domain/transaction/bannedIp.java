package com.qodev.tech.domain.transaction;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trx_banned_ip")
public class bannedIp extends PanacheEntityBase {
    @Id
    @Column(name = "banned_id")
    private String bannedId;

    @Column(name = "banned_attack")
    private String bannedAttack;

    @Column(name = "banned_ip")
    private String bannedIp;

    @Column(name = "banned_status")
    private Integer bannedStatus;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "banned_end_date")
    private Date bannedEndDate;

    @Column(name = "banned_start_date")
    private Date bannedStartDate;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    public String getBannedId() {
        return this.bannedId;
    }

    public void setBannedId(String bannedId) {
        this.bannedId = bannedId;
    }

    public String getBannedAttack() {
        return this.bannedAttack;
    }

    public void setBannedAttack(String bannedAttack) {
        this.bannedAttack = bannedAttack;
    }

    public String getBannedIp() {
        return this.bannedIp;
    }

    public void setBannedIp(String bannedIp) {
        this.bannedIp = bannedIp;
    }

    public Integer getBannedStatus() {
        return this.bannedStatus;
    }

    public void setBannedStatus(Integer bannedStatus) {
        this.bannedStatus = bannedStatus;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getBannedEndDate() {
        return this.bannedEndDate;
    }

    public void setBannedEndDate(Date bannedEndDate) {
        this.bannedEndDate = bannedEndDate;
    }

    public Date getBannedStartDate() {
        return this.bannedStartDate;
    }

    public void setBannedStartDate(Date bannedStartDate) {
        this.bannedStartDate = bannedStartDate;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
