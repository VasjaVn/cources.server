package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * @author odin
 * @since 20.02.17.
 */
public class RegisterResponse implements ResponseData {
	private static final long serialVersionUID = -5146888202653750948L;

	private String registrationRequestUUID;

	private Integer registrationTimeoutSec;

	private Integer authCode;

	public String getRegistrationRequestUUID() {
		return registrationRequestUUID;
	}

	public void setRegistrationRequestUUID(String registrationRequestUUID) {
		this.registrationRequestUUID = registrationRequestUUID;
	}

	public Integer getRegistrationTimeoutSec() {
		return registrationTimeoutSec;
	}

	public void setRegistrationTimeoutSec(Integer registrationTimeoutSec) {
		this.registrationTimeoutSec = registrationTimeoutSec;
	}

	public Integer getAuthCode() {
		return authCode;
	}

	public void setAuthCode(Integer authCode) {
		this.authCode = authCode;
	}
}
