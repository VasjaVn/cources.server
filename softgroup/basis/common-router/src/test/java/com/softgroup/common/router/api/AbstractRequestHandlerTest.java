package com.softgroup.common.router.api;

import com.softgroup.authorization.api.message.LoginRequestData;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.authorization.impl.handler.AuthCmdLoginHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AbstractRequestHandlerTest {

    @Test
    public void test() {
        AbstractRequestHandler<LoginRequestData, LoginResponseData> abstractRequestHandler = new AuthCmdLoginHandler();

        Request<LoginRequestData> loginRequest = new Request<>();
        Response<LoginResponseData> loginResponse = abstractRequestHandler.handle( loginRequest );

        assertThat( loginResponse.getStatus().getCode(), is(200) );
        assertThat( loginResponse.getStatus().getMessage(), is("OK") );
        assertThat( loginResponse.getData().getToken(), is("TOKEN_1") );
    }
}
