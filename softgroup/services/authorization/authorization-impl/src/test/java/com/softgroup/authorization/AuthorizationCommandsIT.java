package com.softgroup.authorization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softgroup.authorization.api.message.LoginRequestData;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.authorization.impl.handler.AuthCmdLoginHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AuthorizationCommandsIT {

    @Test
    public void testCommandLoginHandler() throws IOException {
        String jsonLoginRequest = "{\"header\":{\"uuid\":\"UUID\",\"originUuid\":\"ORIGIN_UUID\",\"command\":\"login\",\"type\":\"authorization\",\"version\":\"v1\"},\"data\":{\"deviceToken\":\"DEVICE_TOKEN_1\"}}";

        Request<LoginRequestData> loginRequest
                = new ObjectMapper().readValue(jsonLoginRequest, new TypeReference<Request<LoginRequestData>>() {});

        Response<LoginResponseData> response = new AuthCmdLoginHandler().handle( loginRequest );

        assertThat( response.getStatus().getCode(), is(200) );
        assertThat( response.getStatus().getMessage(), is("OK") );
        assertThat( response.getData().getToken(), is("TOKEN_1") );
    }
}