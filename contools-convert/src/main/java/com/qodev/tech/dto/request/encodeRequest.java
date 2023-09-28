package com.qodev.tech.dto.request;

public class encodeRequest {
    private String categorise;
    private String input;
    private String aKey;
    private String bKey;
    private String cKey;

    public String getCategorise() {
        return categorise;
    }

    public void setCategorise(String categorise) {
        this.categorise = categorise;
    }

    public String getInput() {
        return this.input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getaKey() {
        return aKey;
    }

    public void setaKey(String aKey) {
        this.aKey = aKey;
    }

    public String getbKey() {
        return bKey;
    }

    public void setbKey(String bKey) {
        this.bKey = bKey;
    }

    public String getcKey() {
        return cKey;
    }

    public void setcKey(String cKey) {
        this.cKey = cKey;
    }
}
