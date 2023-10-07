package com.qodev.tech.dto.request.cryptograph;

import java.util.*;

public class cryptoRequest {
    private String id;
    private String crptoName;
    private String cryptoMode;
    private String scriptMode;
    private ArrayList<Integer> cryptoByte;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCrptoName() {
        return crptoName;
    }

    public void setCrptoName(String crptoName) {
        this.crptoName = crptoName;
    }

    public String getCryptoMode() {
        return cryptoMode;
    }

    public void setCryptoMode(String cryptoMode) {
        this.cryptoMode = cryptoMode;
    }

    public String getScriptMode() {
        return scriptMode;
    }

    public void setScriptMode(String scriptMode) {
        this.scriptMode = scriptMode;
    }

    public ArrayList<Integer> getCryptoByte() {
        return cryptoByte;
    }

    public void setCryptoByte(ArrayList<Integer> cryptoByte) {
        this.cryptoByte = cryptoByte;
    }
}
