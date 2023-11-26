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
    @Autowired private Environment environment;

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

    protected String getServerURL()
    {
        return environment.getProperty(environment() + ".server.url");
    }

    protected String environment()
    {
        return String.valueOf(environment.getProperty("prod"));
    }
}
