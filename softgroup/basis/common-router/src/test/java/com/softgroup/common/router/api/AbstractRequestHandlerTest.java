package com.softgroup.common.router.api;

import com.softgroup.authorization.api.message.LoginRequestData;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.authorization.impl.handler.AuthCmdLoginHandler;
import com.softgroup.common.protocol.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
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

    @Test
    public void test2() {
        AbstractRequestHandler<LoginRequestData, LoginResponseData> abstractRequestHandler =
                new AbstractRequestHandler<LoginRequestData, LoginResponseData>() {
                    @Override
                    public Response commandHandle(Request msg) {
                        Response<LoginResponseData> response = new Response<>();
                        response.setHeader( msg.getHeader() );

                        LoginResponseData loginDataResp = new LoginResponseData();
                        loginDataResp.setToken("TOKEN_1");

                        response.setData( loginDataResp );

                        ResponseStatus status = new ResponseStatus();
                        status.setCode(200);
                        status.setMessage("OK");

                        response.setStatus(status);

                        return response;
                    }

                    @Override
                    public String getName() {
                        return "login";
                    }
                };

        Request<LoginRequestData> loginRequest = new Request<>();
        Response<LoginResponseData> loginResponse = abstractRequestHandler.handle( loginRequest );

        assertThat( loginResponse.getStatus().getCode(), is(200) );
        assertThat( loginResponse.getStatus().getMessage(), is("OK") );
        assertThat( loginResponse.getData().getToken(), is("TOKEN_1") );
    }

    @Test
    public void test3() {
        AbstractRequestHandler<RequestData, ResponseData> abstractRequestHandler = mock(AbstractRequestHandler.class, Mockito.CALLS_REAL_METHODS);

        Request<RequestData> request = new Request<>();
        abstractRequestHandler.handle(request);

        Mockito.verify(abstractRequestHandler).commandHandle(request);
    }
}
