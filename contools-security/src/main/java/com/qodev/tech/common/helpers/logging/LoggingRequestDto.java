package com.qodev.tech.common.helpers.logging;

public class LoggingRequestDto {
    private String appCode;
    private String trxKey;
    private String message;
    private String moduleName;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getTrxKey() {
        return trxKey;
    }

    public void setTrxKey(String trxKey) {
        this.trxKey = trxKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
