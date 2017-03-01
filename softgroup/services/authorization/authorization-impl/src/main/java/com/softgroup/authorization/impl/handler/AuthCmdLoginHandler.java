package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.LoginDataReq;
import com.softgroup.authorization.api.message.LoginDataResp;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthCmdLoginHandler extends AbstractRequestHandler<LoginDataReq, LoginDataResp>
        implements AuthorizationRequestHandler
{
    private static final String AUTH_CMD_LOGIN_NAME = "login";

    @Override
    public String getName() {
        return AUTH_CMD_LOGIN_NAME;
    }
    
    @Override
    public Response<LoginDataResp> commandHandle(Request<LoginDataReq> msg) {
        /*
            Wrote for testing this method.
            In  the future need rewrite this.
            Using some service with access to DB.
        */
        Response<LoginDataResp> response = new Response<>();
        response.setHeader( msg.getHeader() );

        LoginDataResp loginDataResp = new LoginDataResp();
        loginDataResp.setToken("TOKEN_1");

        response.setData( loginDataResp );

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");

        response.setStatus(status);

        return response;
    }
}
