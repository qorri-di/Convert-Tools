package com.qodev.tech.domain.masterdata;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "mst_user")
public class user extends PanacheEntityBase {
    @Id
    @Column(name = "id_user")
    private String userId;

    @Column(name = "alias_user")
    private String aliasUser;

    @Column(name = "name_user")
    private String nameUser;

    @Column(name = "email_user")
    private String emailUser;

    @Column(name = "pass_user")
    private String passUser;

    @Column(name = "status_user")
    private Integer statusUser;

    @Column(name = "reset_pass")
    private Integer resetPwd;

    @Column(name = "token_user")
    private String tokenUser;

    @Column(name = "tokenExpire")
    private String tokenExpire;

    @Column(name = "role_user")
    private String roleUser;

    @Column(name = "start_date", length = 25, nullable = false)
    private String startDate;

    @Column(name = "end_date", length = 25, nullable = false)
    private String endDate;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private Integer updatedBy;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAliasUser() {
        return aliasUser;
    }

    public void setAliasUser(String aliasUser) {
        this.aliasUser = aliasUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public Integer getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(Integer statusUser) {
        this.statusUser = statusUser;
    }

    public Integer getResetPwd() {
        return resetPwd;
    }

    public void setResetPwd(Integer resetPwd) {
        this.resetPwd = resetPwd;
    }

    public String getTokenUser() {
        return tokenUser;
    }

    public void setTokenUser(String tokenUser) {
        this.tokenUser = tokenUser;
    }

    public String getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(String tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
