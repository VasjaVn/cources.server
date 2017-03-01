package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.SmsConfirmDataReq;
import com.softgroup.authorization.api.message.SmsConfirmDataResp;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthCmdSmsConfirmHandler extends AbstractRequestHandler<SmsConfirmDataReq, SmsConfirmDataResp>
        implements AuthorizationRequestHandler
{
    private static final String AUTH_CMD_SMS_CONFIRM_NAME = "sms_confirm";

    @Override
    public String getName() {
        return AUTH_CMD_SMS_CONFIRM_NAME;
    }

    @Override
    public Response<SmsConfirmDataResp> commandHandle(Request<SmsConfirmDataReq> msg) {
        return null;
    }
}
