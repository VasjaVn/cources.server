package com.softgroup.authorization.impl.factory;

import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.factory.CommandHandlerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationCommandHandlerFactory extends CommandHandlerFactory<AuthorizationRequestHandler> {
}
