package com.capstone.server.controller;


import org.apache.commons.codec.binary.*;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;

@Component("DicomViewer")
public class DicomViewer
{
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    private final EUnityConfiguration eUnityConfiguration;

    @Autowired
    public DicomViewer(EUnityConfiguration eUnityConfiguration)
    {
        this.eUnityConfiguration = eUnityConfiguration;
    }

    public String getSignedURL(String username,
                               String studyInstanceUID) throws Exception
    {
        String host = eUnityConfiguration.getHost();
        String port = eUnityConfiguration.getPort();
        String verb = "GET";
        String contentMD5 = "";
        String contentType = "";
        String accessId = eUnityConfiguration.getAccessKey();
        String secret = eUnityConfiguration.getSecret();

        long expiry = getExpiry();

        String queryParams = "studyUID=" +
                studyInstanceUID +
                "&user=" +
                username +
                "&CLOAccessKeyID=" +
                accessId +
                "&enableRelatedStudies=true" +
                "&expiry=" +
                expiry;
        String requestedResource = "/eunityServer/eunityViewer";

        String string_to_sign = verb +
                "\n" +
                contentMD5 +
                "\n" +
                contentType +
                "\n" +
                String.valueOf(expiry) +
                "\n" +
                queryParams +
                requestedResource;
        String signature = sign(secret, string_to_sign);

        return "http://" + host + ":" + port + requestedResource + "?" + queryParams + "&signature=" + signature;
    }

    private String sign(String secret,
                        String string_to_sign) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException
    {
        SecretKeySpec signingKey = new SecretKeySpec(secret.getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(string_to_sign.getBytes());
        byte[] result = Base64.encodeBase64(rawHmac);
        String base64encode = new String(result);
        return URLEncoder.encode(base64encode, "UTF-8");
    }

    private long getExpiry()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.SECOND, eUnityConfiguration.getExpiry());
        Date expiryTime = calendar.getTime();
        return (expiryTime.getTime()) / 1000;
    }
}

