package com.softgroup.common.protocol;

import com.softgroup.authorization.api.message.LoginRequestData;
import com.softgroup.authorization.api.message.LoginResponseData;
import com.softgroup.common.exceptions.ProtocolVersionException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ResponseBuilderTest {

    private String headerUuid = "UUID";
    private String headerOriginUuid = "ORIGIN_UUID";
    private String headerType = "authorization";
    private String headerCommand = "login";
    private String headerVersion = ProtocolVersion.VERSION_1.toString();

    private String dataToken = "TOKEN";

    private Integer statusCode = 200;
    private String statusMessage = "OK";

    private LoginResponseData loginResponseData;

    private RequestBuilder<LoginRequestData> loginRequestBuilder;

    @Before
    public void init() {
        loginResponseData = new LoginResponseData();
        loginResponseData.setToken(dataToken);

        loginRequestBuilder = new RequestBuilder<>();
        loginRequestBuilder
                .withOriginUuid(headerOriginUuid)
                .withType(headerType)
                .withCommand(headerCommand);
    }

    @Test
    public void testLoginResponseBuilder() {
        Request<LoginRequestData> loginRequest = loginRequestBuilder.build();

        ResponseBuilder<LoginRequestData, LoginResponseData> loginResponseBuilder = new ResponseBuilder<>(loginRequest);

        Response<LoginResponseData> loginResponse = loginResponseBuilder
                                                                .withUuid(headerUuid)
                                                                .withData(loginResponseData)
                                                                .withCode(statusCode)
                                                                .withMessage(statusMessage)
                                                                .build();

         assertNotNull( loginResponse );
         assertNotNull( loginResponse.getHeader() );
         assertThat( loginResponse.getHeader().getUuid(), is(headerUuid) );
         assertThat( loginResponse.getHeader().getOriginUuid(), is(headerOriginUuid) );
         assertThat( loginResponse.getHeader().getType(), is(headerType) );
         assertThat( loginResponse.getHeader().getCommand(), is(headerCommand) );
         assertThat( loginResponse.getHeader().getVersion(), is(headerVersion) );
         assertNotNull( loginResponse.getData() );
         assertThat( loginResponse.getData().getToken(), is(dataToken) );
         assertNotNull( loginResponse.getStatus() );
         assertThat( loginResponse.getStatus().getCode(), is(statusCode) );
         assertThat( loginResponse.getStatus().getMessage(), is(statusMessage) );
    }

    @Test (expected = ProtocolVersionException.class)
    public  void testNotEqualVersionResponseBuilder() {
        Request<LoginRequestData> loginRequest = loginRequestBuilder
                                                            .withVersion("ANOTHER_VERSION")
                                                            .build();

        ResponseBuilder<LoginRequestData, LoginResponseData> loginResponseBuilder = new ResponseBuilder<>(loginRequest);
    }
}
