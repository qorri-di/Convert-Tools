package com.qodev.tech.domain.transaction;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trx_cryptograph_mode")
public class TrxCryptographMode {
    @Id
    @Column(name = "crypto_mode_id")
    private String cryptoModeId;

    @Column(name = "crypto_mode_name")
    private String cryptoModeName;

    @Column(name = "crypto_id")
    private String cryptoId;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "crypto_mode_status")
    private String cryptoModeStatus;

    @Column(name = "crypto_mode_script")
    private String cryptoModeScript;

    public String getCryptoModeId() {
        return this.cryptoModeId;
    }

    public void setCryptoModeId(String cryptoModeId) {
        this.cryptoModeId = cryptoModeId;
    }

    public String getCryptoModeName() {
        return this.cryptoModeName;
    }

    public void setCryptoModeName(String cryptoModeName) {
        this.cryptoModeName = cryptoModeName;
    }

    public String getCryptoId() {
        return this.cryptoId;
    }

    public void setCryptoId(String cryptoId) {
        this.cryptoId = cryptoId;
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

    public String getCryptoModeStatus() {
        return this.cryptoModeStatus;
    }

    public void setCryptoModeStatus(String cryptoModeStatus) {
        this.cryptoModeStatus = cryptoModeStatus;
    }

    public String getCryptoModeScript() {
        return this.cryptoModeScript;
    }

    public void setCryptoModeScript(String cryptoModeScript) {
        this.cryptoModeScript = cryptoModeScript;
    }
}
