package com.capstone.server.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.*;

@Configuration
@PropertySource(value = "classpath:/eunity.properties")
public class EUnityConfiguration
{
    private static final String PROPERTY_PROFILE = "profile";
    private static final String PROPERTY_HOST = "eunity-host";
    private static final String PROPERTY_PORT = "eunity-port";
    private static final String PROPERTY_EXPIRY = "eunity-expiry";
    private static final String PROPERTY_ACCESS_KEY = "eunity-accessKey";
    private static final String PROPERTY_SECRET = "eunity-secret";

    @Autowired private Environment environment;

    public String getHost()
    {
        return environment.getProperty(getProfile() + "." + PROPERTY_HOST);
    }

    public String getPort()
    {
        return environment.getProperty(PROPERTY_PORT);
    }

    public int getExpiry()
    {
        return Integer.valueOf(environment.getProperty(PROPERTY_EXPIRY));
    }

    public String getAccessKey()
    {
        return environment.getProperty(getProfile() + "." + PROPERTY_ACCESS_KEY);
    }

    public String getSecret()
    {
        return environment.getProperty(getProfile() + "." + PROPERTY_SECRET);
    }

    private String getProfile()
    {
        return environment.getProperty(PROPERTY_PROFILE);
    }
}

