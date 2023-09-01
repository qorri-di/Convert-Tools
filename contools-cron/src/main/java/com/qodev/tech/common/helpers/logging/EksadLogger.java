package com.qodev.tech.common.helpers.logging;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Singleton
public class EksadLogger {
    @Inject
    @RestClient
    LogServiceApi logServiceApi;

    private SimpleDateFormat logFormatter=new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public String getTransactionKey(String key) {
        Date currentDate=new Date();
        String dateFormatted= logFormatter.format(currentDate)+ ThreadLocalRandom.current().nextInt(100,999);
        return String.format("%s.%s",key,dateFormatted);
    }

    public String getTransactionKey() {
        return getTransactionKey("LOG");
    }

    public void saveBL(String message, String appCode,String moduleName, String transactionKey) {
        LoggingRequestDto logRequest=new LoggingRequestDto();
        logRequest.setMessage(message);
        logRequest.setAppCode(appCode);
        logRequest.setModuleName(moduleName);
        logRequest.setTrxKey(transactionKey);
        logServiceApi.bussinessSave(logRequest);
    }

    public void saveBL(String message,String appCode,String moduleName) {
        saveBL(message,appCode,moduleName,null);
    }

    public void saveBL(String message,String appCode) {
        saveBL(message,appCode,EksadLogger.class.getCanonicalName(),null);
    }

    public void saveBL(String message) {
        saveBL(message,"N/A",EksadLogger.class.getCanonicalName(),null);
    }

}
