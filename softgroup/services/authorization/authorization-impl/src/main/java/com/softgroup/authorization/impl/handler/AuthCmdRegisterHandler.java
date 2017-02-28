package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthCmdRegisterHandler extends AbstractRequestHandler<RegisterRequest, RegisterResponse>
        implements AuthorizationRequestHandler
{
    private static final String AUTH_CMD_REGISTER_NAME = "register";

    @Override
    public String getName() {
        return AUTH_CMD_REGISTER_NAME;
    }

    @Override
    public Response<RegisterResponse> handle(Request<?> msg) {
        return null;
    }
}
