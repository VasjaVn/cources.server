package com.softgroup.messenger.impl.factory;

import com.softgroup.common.factory.CommandHandlerFactory;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class MessengerCommandHandlerFactory extends CommandHandlerFactory<MessengerRequestHandler> {
}