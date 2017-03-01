package com.softgroup.authorization;

import com.softgroup.authorization.api.message.LoginRequestData;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.authorization.impl.handler.AuthCmdLoginHandler;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AuthorizationCommandsIT {

    @Spy
    AuthCmdLoginHandler cmdLoginHandler = new AuthCmdLoginHandler();

    @Test
    public void testCommandLoginHandler() {
        ActionHeader header
                = mock(ActionHeader.class);
        when(header.getUuid()).thenReturn("UUID_1");
        when(header.getOriginUuid()).thenReturn("ORIGIN_UUID_1");
        when(header.getCommand()).thenReturn("login");
        when(header.getType()).thenReturn("authorization");
        when(header.getVersion()).thenReturn("V1");

        LoginRequestData loginDataReq
                = mock(LoginRequestData.class);
        when(loginDataReq.getDeviceToken()).thenReturn("DEVICE_TOKEN_1");

        Request<LoginRequestData> request
                = mock(Request.class);
        when(request.getHeader()).thenReturn(header);
        when(request.getData()).thenReturn(loginDataReq);

        Response<LoginResponseData> response = cmdLoginHandler.handle(request);
        Integer code = response.getStatus().getCode();
        String message = response.getStatus().getMessage();
        String token = response.getData().getToken();

        assertThat( code, is(200) );
        assertThat( message, is("OK") );
        assertThat( token, is("TOKEN_1") );
    }
}
