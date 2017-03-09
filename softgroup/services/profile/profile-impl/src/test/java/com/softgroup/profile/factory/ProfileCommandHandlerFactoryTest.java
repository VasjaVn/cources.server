package com.softgroup.profile.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestBuilder;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.impl.factory.ProfileCommandHandlerFactory;
import com.softgroup.profile.impl.handler.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ProfileCommandHandlerFactoryTest {

    private static final String PROFILE_TYPE_NAME = "profile";

    private static final String CMD_CONTACTS_SYNC_NAME        = "contacts_sync";
    private static final String CMD_GET_CONTACT_PROFILES_NAME = "get_contact_profiles";
    private static final String CMD_GET_MY_PROFILE_NAME       = "get_my_profile";
    private static final String CMD_SET_MY_PROFILE_NAME       = "set_my_profile";
    private static final String CMD_GET_OTHER_PROFILES_NAME   = "get_other_profiles";
    private static final String CMD_GET_PROFILE_SETTINGS_NAME = "get_profile_settings";
    private static final String CMD_SET_PROFILE_SETTINGS_NAME = "set_profile_settings";
    private static final String CMD_GET_LAST_TIME_ONLINE      = "get_last_time_online";

    @Spy
    private List<ProfileRequestHandler> listHandlers = new ArrayList<>();

    @InjectMocks
    private ProfileCommandHandlerFactory factory;

    private ProfileRequestHandler cmdContactsSyncHandler       = new ProfCmdContactsSyncHandler();
    private ProfileRequestHandler cmdGetContactProfilesHandler = new ProfCmdGetContactProfilesHandler();
    private ProfileRequestHandler cmdGetMyProfileHandler       = new ProfCmdGetMyProfileHandler();
    private ProfileRequestHandler cmdSetMyProfileHandler       = new ProfCmdSetMyProfileHandler();
    private ProfileRequestHandler cmdGetOtherProfilesHandler   = new ProfCmdGetOtherProfilesHandler();
    private ProfileRequestHandler cmdGetProfileSettingsHandler = new ProfCmdGetProfileSettingsHandler();
    private ProfileRequestHandler cmdSetProfileSettingsHandler = new ProfCmdSetProfileSettingsHandler();
    private ProfileRequestHandler cmdGetLastTimeOnlineHandler  = new ProfCmdGetLastTimeOnlineHandler();

    private Request<?> contactsSyncRequest;
    private Request<?> getContactProfilesRequest;
    private Request<?> getMyProfileRequest;
    private Request<?> setMyProfileRequest;
    private Request<?> getOtherProfileRequest;
    private Request<?> getProfileSettingsRequest;
    private Request<?> setProfileSettingsRequest;
    private Request<?> getLastTimeOnlineRequest;


    @Before
    public void init() {
        listHandlers.add( cmdContactsSyncHandler );
        listHandlers.add( cmdGetContactProfilesHandler );
        listHandlers.add( cmdGetMyProfileHandler );
        listHandlers.add( cmdSetMyProfileHandler );
        listHandlers.add( cmdGetOtherProfilesHandler );
        listHandlers.add( cmdGetProfileSettingsHandler );
        listHandlers.add( cmdSetProfileSettingsHandler );
        listHandlers.add( cmdGetLastTimeOnlineHandler );

        factory.init();

        RequestBuilder<?> contactsSyncRequestBuilder = new RequestBuilder<>();
        contactsSyncRequest = contactsSyncRequestBuilder
                                                    .withType( PROFILE_TYPE_NAME )
                                                    .withCommand( CMD_CONTACTS_SYNC_NAME )
                                                    .build();

        RequestBuilder<?> getContactProfilesRequestBuilder = new RequestBuilder<>();
        getContactProfilesRequest = getContactProfilesRequestBuilder
                                                            .withType( PROFILE_TYPE_NAME )
                                                            .withCommand( CMD_GET_CONTACT_PROFILES_NAME )
                                                            .build();

        RequestBuilder<?> getMyProfileRequestBuilder = new RequestBuilder<>();
        getMyProfileRequest = getMyProfileRequestBuilder
                                                    .withType( PROFILE_TYPE_NAME )
                                                    .withCommand( CMD_GET_MY_PROFILE_NAME )
                                                    .build();

        RequestBuilder<?> setMyProfileRequestBuilder = new RequestBuilder<>();
        setMyProfileRequest = setMyProfileRequestBuilder
                                                    .withType( PROFILE_TYPE_NAME )
                                                    .withCommand( CMD_SET_MY_PROFILE_NAME )
                                                    .build();

        RequestBuilder<?> getOtherProfileRequestBuilder = new RequestBuilder<>();
        getOtherProfileRequest = getOtherProfileRequestBuilder
                                                        .withType( PROFILE_TYPE_NAME )
                                                        .withCommand( CMD_GET_OTHER_PROFILES_NAME )
                                                        .build();

        RequestBuilder<?> getProfileSettingsRequestBuilder = new RequestBuilder<>();
        getProfileSettingsRequest = getProfileSettingsRequestBuilder
                                                                .withType( PROFILE_TYPE_NAME )
                                                                .withCommand( CMD_GET_PROFILE_SETTINGS_NAME )
                                                                .build();

        RequestBuilder<?> setProfileSettingsRequestBuilder = new RequestBuilder<>();
        setProfileSettingsRequest = setProfileSettingsRequestBuilder
                                                                .withType( PROFILE_TYPE_NAME )
                                                                .withCommand( CMD_SET_PROFILE_SETTINGS_NAME )
                                                                .build();

        RequestBuilder<?> getLastTimeOnlineRequestBuilder = new RequestBuilder<>();
        getLastTimeOnlineRequest = getLastTimeOnlineRequestBuilder
                                                            .withType( PROFILE_TYPE_NAME )
                                                            .withCommand( CMD_GET_LAST_TIME_ONLINE )
                                                            .build();
    }

    @Test
    public void testGetKey() {
        assertThat( factory.getKey( contactsSyncRequest ), is( CMD_CONTACTS_SYNC_NAME ) );
        assertThat( factory.getKey( getContactProfilesRequest ), is( CMD_GET_CONTACT_PROFILES_NAME ) );
        assertThat( factory.getKey( getMyProfileRequest ), is( CMD_GET_MY_PROFILE_NAME ) );
        assertThat( factory.getKey( setMyProfileRequest ), is( CMD_SET_MY_PROFILE_NAME ) );
        assertThat( factory.getKey( getOtherProfileRequest ), is( CMD_GET_OTHER_PROFILES_NAME ) );
        assertThat( factory.getKey( getProfileSettingsRequest ), is( CMD_GET_PROFILE_SETTINGS_NAME ) );
        assertThat( factory.getKey( setProfileSettingsRequest ), is( CMD_SET_PROFILE_SETTINGS_NAME ) );
        assertThat( factory.getKey( getLastTimeOnlineRequest ), is( CMD_GET_LAST_TIME_ONLINE ) );
    }

    @Test
    public void testGetHandler() {
        assertThat( factory.getHandler( contactsSyncRequest ), is( cmdContactsSyncHandler ) );
        assertThat( factory.getHandler( getContactProfilesRequest ), is( cmdGetContactProfilesHandler ) );
        assertThat( factory.getHandler( getMyProfileRequest ), is( cmdGetMyProfileHandler ) );
        assertThat( factory.getHandler( setMyProfileRequest ), is( cmdSetMyProfileHandler ) );
        assertThat( factory.getHandler( getOtherProfileRequest ), is( cmdGetOtherProfilesHandler ) );
        assertThat( factory.getHandler( getProfileSettingsRequest ), is( cmdGetProfileSettingsHandler ) );
        assertThat( factory.getHandler( setProfileSettingsRequest ), is( cmdSetProfileSettingsHandler ) );
        assertThat( factory.getHandler( getLastTimeOnlineRequest ), is( cmdGetLastTimeOnlineHandler ) );
    }
}
