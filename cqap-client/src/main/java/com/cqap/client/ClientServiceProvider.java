package com.cqap.client;


import com.fasterxml.jackson.databind.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.*;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.*;
import org.springframework.web.client.*;

import java.util.*;

@Configuration
@PropertySource(value = "classpath:/cqap-client.properties")
public class ClientServiceProvider
{
    @Autowired private Environment theEnvironment;

    @Bean
    public RestTemplate restTemplate()
    {
        RestTemplate myRestTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> myConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter myMapper = new MappingJackson2HttpMessageConverter();
        ObjectMapper myObjectMapper = new ObjectMapper();
        myObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        myObjectMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        myMapper.setObjectMapper(myObjectMapper);
        myConverters.add(new ByteArrayHttpMessageConverter());
        myConverters.add(new FormHttpMessageConverter());
        myConverters.add(new StringHttpMessageConverter());
        myConverters.add(myMapper);
        myRestTemplate.getMessageConverters().addAll(myConverters);
        return myRestTemplate;
    }

    @Bean
    public ClientRestService clientService()
    {
        return new ClientRestService(getServerURL());
    }

    private String getServerURL()
    {
        return isProd() ? theEnvironment.getProperty("prod.server.url") : theEnvironment.getProperty("test.server.url");
    }

    private boolean isProd()
    {
        return Boolean.valueOf(theEnvironment.getProperty("prod"));
    }
}
