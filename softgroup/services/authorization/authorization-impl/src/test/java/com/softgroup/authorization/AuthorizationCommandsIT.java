package com.softgroup.authorization;

import com.softgroup.authorization.api.message.LoginRequestData;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.authorization.impl.handler.AuthCmdLoginHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class AuthorizationCommandsIT {

    @Spy
    AuthCmdLoginHandler cmdLoginHandler = new AuthCmdLoginHandler();

    @Test
    public void testCommandLoginHandler() {
        Request<LoginRequestData> request = mock(Request.class);

        Response<LoginResponseData> response = cmdLoginHandler.handle(request);
        
        assertThat( response.getStatus().getCode(), is(200) );
        assertThat( response.getStatus().getMessage(), is("OK") );
        assertThat( response.getData().getToken(), is("TOKEN_1") );
    }
}
