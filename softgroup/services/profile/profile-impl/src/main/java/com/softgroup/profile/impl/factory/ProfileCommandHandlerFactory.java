package com.softgroup.profile.impl.factory;

import com.softgroup.common.factory.CommandHandlerFactory;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class ProfileCommandHandlerFactory extends CommandHandlerFactory<ProfileRequestHandler> {
}
