package com.cqap.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "client")
public class ClientProperties {

    private String serverUrl;

    // standard getters and setters
    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

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
}

