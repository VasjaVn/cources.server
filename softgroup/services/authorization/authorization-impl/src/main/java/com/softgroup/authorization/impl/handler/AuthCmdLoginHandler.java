package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.LoginRequestData;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthCmdLoginHandler extends AbstractRequestHandler<LoginRequestData, LoginResponseData>
        implements AuthorizationRequestHandler
{
    private static final String AUTH_CMD_LOGIN_NAME = "login";

    @Override
    public String getName() {
        return AUTH_CMD_LOGIN_NAME;
    }
    
    @Override
    public Response<LoginResponseData> commandHandle(Request<LoginRequestData> msg) {
        /*
            Wrote for testing this method.
            In  the future need rewrite this.
            Using some service with access to DB.
        */
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
}
