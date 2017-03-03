package com.softgroup.authorization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.softgroup.authorization.api.message.LoginRequestData;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.authorization.impl.handler.AuthCmdLoginHandler;
import com.softgroup.common.datamapper.JacksonDataMapper;
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
                = new JacksonDataMapper().mapData(jsonLoginRequest, new TypeReference<Request<LoginRequestData>>() {});

        Response<LoginResponseData> loginResponse = new AuthCmdLoginHandler().handle( loginRequest );

        assertThat( loginResponse.getStatus().getCode(), is(200) );
        assertThat( loginResponse.getStatus().getMessage(), is("OK") );
        assertThat( loginResponse.getData().getToken(), is("TOKEN_1") );
    }
}