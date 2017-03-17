package com.softgroup.common.router.impl.dispatcher;

import com.softgroup.common.factory.HandlerFactory;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.RouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispatcherRouterHandler implements RouterHandler {
    private static final String DISPATCHER_TYPE_ROUTER_NAME = "dispatcher";

    @Autowired
    private HandlerFactory<CommonRouterHandler> routerHandlerFactory;

    @Override
    public String getName() {
        return DISPATCHER_TYPE_ROUTER_NAME;
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        return routerHandlerFactory.getHandler(msg).handle(msg);
    }

    @Override
    public String getRouteKey(Request<?> msg) {
        return null;
    }
}