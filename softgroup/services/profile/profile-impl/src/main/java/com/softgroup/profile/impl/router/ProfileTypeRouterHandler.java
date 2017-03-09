package com.softgroup.profile.impl.router;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.profile.api.router.ProfileRouterHandler;
import com.softgroup.profile.impl.factory.ProfileCommandHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileTypeRouterHandler implements ProfileRouterHandler
{
    private static final String PROFILE_TYPE_ROUTER_NAME = "profile";

    @Autowired
    private ProfileCommandHandlerFactory commandHandlerFactory;

    @Override
    public String getName() {
        return PROFILE_TYPE_ROUTER_NAME;
    }

    @Override
    public Response<?> handle(Request<?> request) {
        return commandHandlerFactory.getHandler( request ).handle( request );
    }

    @Override
    public String getRouteKey(Request<?> msg) {
        return null;
    }
}
