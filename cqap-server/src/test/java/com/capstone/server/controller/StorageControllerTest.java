package com.capstone.server.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StorageControllerTest
{

    private RestTemplate theRestTemplate;

    @Before
    public void setUp() throws Exception
    {
        theRestTemplate = restTemplate();
    }

    @Disabled
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

//    @Test
//    public void selectTicket() throws Exception
//    {
//        MongoTemplate myTemplate = new MongoTemplate(new SimpleMongoDbFactory(new MongoURI("mongodb://writer:writer@172.19.217.204:27017/peirs")));
//        BasicQuery query1 = new BasicQuery("{ theViewId : 'PR-915' }");
//        List<ProfessionalTicket> myPRTickets = myTemplate.find(query1, ProfessionalTicket.class, "PRTickets");
//        System.out.println(myPRTickets);
//
//        Query myQuery = new Query();
//        myQuery.with(new Sort(Sort.Direction.DESC, "theSubmittedTime"));
//        myQuery.addCriteria(Criteria.where("theViewId").in("PR-915"));
//        myQuery.addCriteria(Criteria.where("theDeleted").is(false));
//        List<ProfessionalTicket> myProfessionalTickets = myTemplate.find(myQuery, ProfessionalTicket.class);
//        System.out.println(myProfessionalTickets);
//        LambdaList<TicketQueryResult> myQueryResults =
//                with(myProfessionalTickets).convert(new TicketQueryResultConverter());
//        System.out.println(myQueryResults);
//    }

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
