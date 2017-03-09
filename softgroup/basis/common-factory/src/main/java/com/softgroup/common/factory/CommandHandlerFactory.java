package com.softgroup.common.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;

public class CommandHandlerFactory<T extends Handler> extends AbstractHandlerFactory<T> {

    @Override
    public String getKey(Request<?> request) {
        return request.getHeader().getCommand();
    }
}
