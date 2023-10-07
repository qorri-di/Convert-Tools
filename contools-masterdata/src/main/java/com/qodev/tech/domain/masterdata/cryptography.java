package com.qodev.tech.domain.masterdata;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_cryptography")
public class cryptography {
    @Id
    @Column(name = "crypto_id")
    private String cryptoId;

    @Column(name = "crypto_name")
    private String cryptoName;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "crypto_status")
    private Long cryptoStatus;

    public String getCryptoId() {
        return this.cryptoId;
    }

    public void setCryptoId(String cryptoId) {
        this.cryptoId = cryptoId;
    }

    public String getCryptoName() {
        return this.cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCryptoStatus() {
        return this.cryptoStatus;
    }

    public void setCryptoStatus(Long cryptoStatus) {
        this.cryptoStatus = cryptoStatus;
    }
}
