package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthCmdLoginHandler extends AbstractRequestHandler<LoginRequest, LoginResponse>
        implements AuthorizationRequestHandler
{
    private static final String AUTH_CMD_LOGIN_NAME = "login";

    @Override
    public String getName() {
        return AUTH_CMD_LOGIN_NAME;
    }
    
    @Override
    public Response<LoginResponse> commandHandle(Request<LoginRequest> msg) {
        return null;
    }
}
