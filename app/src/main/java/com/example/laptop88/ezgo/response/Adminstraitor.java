package com.example.laptop88.ezgo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Adminstraitor implements Serializable {

    @SerializedName("adminstraitorName")
    @Expose
    private String adminstraitorName;

    @SerializedName("adminPhoneNum")
    @Expose
    private String adminPhoneNum;

    public Adminstraitor(String adminstraitorName, String adminPhoneNum) {
        this.adminstraitorName = adminstraitorName;
        this.adminPhoneNum = adminPhoneNum;
    }

    public String getAdminstraitorName() {
        return adminstraitorName;
    }

    public void setAdminstraitorName(String adminstraitorName) {
        this.adminstraitorName = adminstraitorName;
    }

    public String getAdminPhoneNum() {
        return adminPhoneNum;
    }

    public void setAdminPhoneNum(String adminPhoneNum) {
        this.adminPhoneNum = adminPhoneNum;
    }
}
