package com.softgroup.common.protocol;

import com.softgroup.authorization.api.message.LoginRequestData;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class RequestBuilderTest {

    @Test
    public void testLoginRequestBuilder() {
        String headerUuid = "";
        String headerOriginUuid = "03aedcd3-5638-4887-8c92-43fae4047a5b";
        String headerType = "authorization";
        String headerCommand = "login";
        String headerVersion = "v1.0";

        String dataDeviceToken = "DEVICE_TOKEN";

        LoginRequestData loginRequestData = new LoginRequestData();
        loginRequestData.setDeviceToken(dataDeviceToken);

        RequestBuilder<LoginRequestData> loginRequestBuilder = new RequestBuilder<>();
        Request<LoginRequestData> loginRequest = loginRequestBuilder
                                                        .withOriginUuid(headerOriginUuid)
                                                        .withType(headerType)
                                                        .withCommand(headerCommand)
                                                        .withVersion(headerVersion)
                                                        .withData(loginRequestData)
                                                        .build();

        assertNotNull( loginRequest );
        assertNotNull( loginRequest.getHeader() );
        assertThat( loginRequest.getHeader().getUuid(), is(headerUuid) );
        assertThat( loginRequest.getHeader().getOriginUuid(), is(headerOriginUuid) );
        assertThat( loginRequest.getHeader().getType(), is(headerType) );
        assertThat( loginRequest.getHeader().getCommand(), is(headerCommand) );
        assertThat( loginRequest.getHeader().getVersion(), is(headerVersion) );
        assertNotNull( loginRequest.getData() );
        assertThat( loginRequest.getData().getDeviceToken(), is(dataDeviceToken) );
    }
}
