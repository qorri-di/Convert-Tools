package com.qodev.tech.domain.transaction;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trx_feature_logs")
public class featureLogs extends PanacheEntityBase {
    @Id
    @Column(name = "feature_log_id")
    private String featureLogId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "feature_log_featureId")
    private String featureLogFeatureId;

    @Column(name = "feature_log_ip")
    private String featureLogIp;

    @Column(name = "feature_log_menu")
    private String featureLogMenu;

    @Column(name = "feature_log_path")
    private String featureLogPath;

    public String getFeatureLogId() {
        return this.featureLogId;
    }

    public void setFeatureLogId(String featureLogId) {
        this.featureLogId = featureLogId;
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

    public String getFeatureLogFeatureId() {
        return this.featureLogFeatureId;
    }

    public void setFeatureLogFeatureId(String featureLogFeatureId) {
        this.featureLogFeatureId = featureLogFeatureId;
    }

    public String getFeatureLogIp() {
        return this.featureLogIp;
    }

    public void setFeatureLogIp(String featureLogIp) {
        this.featureLogIp = featureLogIp;
    }

    public String getFeatureLogMenu() {
        return this.featureLogMenu;
    }

    public void setFeatureLogMenu(String featureLogMenu) {
        this.featureLogMenu = featureLogMenu;
    }

    public String getFeatureLogPath() {
        return this.featureLogPath;
    }

    public void setFeatureLogPath(String featureLogPath) {
        this.featureLogPath = featureLogPath;
    }
}
