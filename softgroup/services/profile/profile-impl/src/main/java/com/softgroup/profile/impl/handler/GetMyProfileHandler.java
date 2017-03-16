package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetMyProfileRequestData;
import com.softgroup.profile.api.message.GetMyProfileResponseData;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class GetMyProfileHandler
        extends AbstractRequestHandler<GetMyProfileRequestData, GetMyProfileResponseData>
        implements ProfileRequestHandler
{
    private static final String PROF_CMD_GET_MY_PROFILE_NAME = "get_my_profile";

    @Override
    public String getName() {
        return PROF_CMD_GET_MY_PROFILE_NAME;
    }

    @Override
    public Response<GetMyProfileResponseData> commandHandle(Request<GetMyProfileRequestData> request) {
        return null;
    }
}