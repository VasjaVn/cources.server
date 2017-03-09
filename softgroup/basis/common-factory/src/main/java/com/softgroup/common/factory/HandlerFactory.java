package com.softgroup.common.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;

public interface HandlerFactory<T extends Handler> {
    T getHandler(Request<?> request);
}
