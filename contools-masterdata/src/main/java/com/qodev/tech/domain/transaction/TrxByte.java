package com.qodev.tech.domain.transaction;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trx_byte")
public class TrxByte {
    @Id
    @Column(name = "byte_id")
    private String byteId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "byte_name")
    private Long byteName;

    @Column(name = "byte_status")
    private Long byteStatus;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "crypto_id")
    private String cryptoId;

    public String getByteId() {
        return this.byteId;
    }

    public void setByteId(String byteId) {
        this.byteId = byteId;
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

    public Long getByteName() {
        return this.byteName;
    }

    public void setByteName(Long byteName) {
        this.byteName = byteName;
    }

    public Long getByteStatus() {
        return this.byteStatus;
    }

    public void setByteStatus(Long byteStatus) {
        this.byteStatus = byteStatus;
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

    public String getCryptoId() {
        return this.cryptoId;
    }

    public void setCryptoId(String cryptoId) {
        this.cryptoId = cryptoId;
    }
}
