package com.capstone.server.controller;

import com.peirs.datamodel.attachments.*;
import org.codehaus.jackson.map.*;
import org.junit.*;
import org.springframework.core.io.*;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.*;
import org.springframework.util.*;
import org.springframework.web.client.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class StorageControllerTest
{

    private RestTemplate theRestTemplate;

    @Before
    public void setUp() throws Exception
    {
        theRestTemplate = restTemplate();
    }

    @Test
    public void uploadFile() throws Exception
    {
        File myFile = new File(getClass().getClassLoader().getResource("test.docx").getPath());
        MultiValueMap<String, Object> myValues = new LinkedMultiValueMap<>();
//        myValues.add("file", new FileSystemResource(myFile));
//        myValues.add("ticketId", "5266aa6011a8a6f909b8d402");
        myValues.add("id", "5266df6cc2e643ca9619c7d0");
        ByteArrayResource
                myAttachments =
                theRestTemplate.postForObject("http://localhost:18080/cqap-server/tickets/getAttachment",
                        myValues, ByteArrayResource.class);

    }

    public RestTemplate restTemplate()
    {
        RestTemplate myRestTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> myConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJacksonHttpMessageConverter myMapper = new MappingJacksonHttpMessageConverter();
        ObjectMapper myObjectMapper = new ObjectMapper();
        myObjectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        myObjectMapper.configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, true);
        myMapper.setObjectMapper(myObjectMapper);
        myConverters.add(new ByteArrayHttpMessageConverter());
        myConverters.add(new FormHttpMessageConverter());
        myConverters.add(new StringHttpMessageConverter());
        myConverters.add(myMapper);
        myRestTemplate.getMessageConverters().addAll(myConverters);
        return myRestTemplate;
    }
}
