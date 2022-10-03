package com.app.Spotify.Service;

import com.app.Spotify.Config.ConnectionConfig;
import com.app.Spotify.DTO.TokenDto;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Base64;
import java.util.Map;

@Service
public class TokenService
{
    public String getToken(String code) throws IOException, JSONException {

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        ConnectionConfig conn = new ConnectionConfig();
        // request body parameters
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "authorization_code");
        map.add("code", code);
        map.add("redirect_uri", conn.getRedirect_Url());


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString(
                (conn.getClient_id() + ":" + conn.getSecret()).getBytes()));

        // send POST request
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);


        ResponseEntity<TokenDto> responseEntity = restTemplate.exchange(
                conn.getTokenUrl(),
                HttpMethod.POST,
                entity,
                TokenDto.class
        );


        System.out.println(conn.getTokenUrl());
        return responseEntity.getBody().getAccess_token();

    }
}
