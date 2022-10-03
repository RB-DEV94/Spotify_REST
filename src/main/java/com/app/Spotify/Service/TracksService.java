package com.app.Spotify.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
public class TracksService
{
    private static final String URL = "https://api.spotify.com/v1/me/tracks?limit=50";

    public Object getTracks(String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> entity = new HttpEntity<>("paramters", headers);

        ResponseEntity<Object> response = restTemplate.exchange(URL, HttpMethod.GET, entity, Object.class);
        LinkedHashMap result = (LinkedHashMap) response.getBody();

        ArrayList items = (ArrayList) result.get("items");

        return result;
    }
}
