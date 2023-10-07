package com.qodev.tech.domain.masterdata;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_packet")
public class packet extends PanacheEntityBase {
    @Id
    @Column(name = "id_packet")
    private String packetId;

    @Column(name = "name_packet")
    private String namePacket;

    @Column(name = "quota_packet")
    private Integer quotaPacket;

    @Column(name = "status_packet")
    private Integer statusPacket;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    public String getPacketId() {
        return packetId;
    }

    public void setPacketId(String packetId) {
        this.packetId = packetId;
    }

    public String getNamePacket() {
        return namePacket;
    }

    public void setNamePacket(String namePacket) {
        this.namePacket = namePacket;
    }

    public Integer getQuotaPacket() {
        return quotaPacket;
    }

    public void setQuotaPacket(Integer quotaPacket) {
        this.quotaPacket = quotaPacket;
    }

    public Integer getStatusPacket() {
        return statusPacket;
    }

    public void setStatusPacket(Integer statusPacket) {
        this.statusPacket = statusPacket;
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
