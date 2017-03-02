package com.softgroup.authorization;

import com.softgroup.authorization.api.message.LoginRequestData;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.authorization.impl.handler.AuthCmdLoginHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AuthorizationCommandsIT {

    @Test
    public void testCommandLoginHandler() {
        Request<LoginRequestData> request = new Request<>();

        Response<LoginResponseData> response = new AuthCmdLoginHandler().handle( request );

        assertThat( response.getStatus().getCode(), is(200) );
        assertThat( response.getStatus().getMessage(), is("OK") );
        assertThat( response.getData().getToken(), is("TOKEN_1") );
    }
}
