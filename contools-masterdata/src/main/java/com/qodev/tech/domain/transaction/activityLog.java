package com.qodev.tech.domain.transaction;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trx_activity_log")
public class activityLog extends PanacheEntityBase {
    @Id
    @Column(name = "activity_id")
    private String activityId;

    @Column(name = "activity_feature")
    private String activityFeature;

    @Column(name = "activity_ip")
    private String activityIp;

    @Column(name = "activity_menu")
    private String activityMenu;

    @Column(name = "activity_path")
    private String activityPath;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    public String getActivityId() {
        return this.activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityFeature() {
        return this.activityFeature;
    }

    public void setActivityFeature(String activityFeature) {
        this.activityFeature = activityFeature;
    }

    public String getActivityIp() {
        return this.activityIp;
    }

    public void setActivityIp(String activityIp) {
        this.activityIp = activityIp;
    }

    public String getActivityMenu() {
        return this.activityMenu;
    }

    public void setActivityMenu(String activityMenu) {
        this.activityMenu = activityMenu;
    }

    public String getActivityPath() {
        return this.activityPath;
    }

    public void setActivityPath(String activityPath) {
        this.activityPath = activityPath;
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
}
