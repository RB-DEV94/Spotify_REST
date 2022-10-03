package com.app.Spotify.Service;

import com.app.Spotify.Config.ConnectionConfig;
import com.app.Spotify.DTO.TokenDto;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashMap;

@Service
public class AlbumsService
{

    TokenDto token=new TokenDto();



    public Object getAlbums(String token) throws IOException, JSONException {
        RestTemplate restTemplate = new RestTemplate();
        ConnectionConfig conn = new ConnectionConfig();
        // request body parameters
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer"+" "+token);
        System.out.println("Bearer"+" "+token);

        // send POST request
        HttpEntity<String> entity = new HttpEntity<>(headers);


        ResponseEntity<Object> responseEntity = restTemplate.exchange("https://api.spotify.com/v1/me/albums?market=US&limit=20",
                HttpMethod.GET,
                entity,
                Object.class
        );
        System.out.println(responseEntity.getBody());

        LinkedHashMap result = (LinkedHashMap) responseEntity.getBody();
        return result;

    }


}
