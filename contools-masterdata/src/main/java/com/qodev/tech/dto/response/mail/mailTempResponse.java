package com.qodev.tech.dto.response.mail;

import java.util.List;

public class mailTempResponse {
    private Integer id;
    private String website;
    private List<String> mail_temp;
    private Integer active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<String> getMail_temp() {
        return mail_temp;
    }

    public void setMail_temp(List<String> mail_temp) {
        this.mail_temp = mail_temp;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
