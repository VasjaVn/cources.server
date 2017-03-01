package com.softgroup.common.router.api;

import com.softgroup.authorization.api.message.LoginRequestData;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AbstractRequestHandlerTest {
    @Test
    public void test() {
        AbstractRequestHandler<LoginRequestData, LoginResponseData> arh = mock(AbstractRequestHandler.class, Mockito.CALLS_REAL_METHODS);

        Request<LoginRequestData> loginRequest = mock(Request.class);
        Response<LoginResponseData> loginResponse = mock(Response.class);

        when(arh.getName()).thenReturn("login");
        when(arh.commandHandle(loginRequest)).thenReturn(loginResponse);
        when(arh.handle(loginRequest)).thenCallRealMethod();

        Response<LoginResponseData> loginResponseResult = arh.handle(loginRequest);
    }
}
