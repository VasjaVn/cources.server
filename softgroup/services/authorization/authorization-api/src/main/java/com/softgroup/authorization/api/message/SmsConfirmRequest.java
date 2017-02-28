package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.RequestData;

public class SmsConfirmRequest implements RequestData {

    private Integer authCode;

    private String registrationRequestUUID;

    public Integer getAuthCode() {
        return authCode;
    }

    public void setAuthCode(Integer authCode) {
        this.authCode = authCode;
    }

    public String getRegistrationRequestUUID() {
        return registrationRequestUUID;
    }

    public void setRegistrationRequestUUID(String registrationRequestUUID) {
        this.registrationRequestUUID = registrationRequestUUID;
    }
}
