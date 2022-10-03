package com.app.Spotify.Service;

import com.app.Spotify.Config.ConnectionConfig;
import com.app.Spotify.Utility.CodeChallengeUtility;
import com.app.Spotify.Utility.CodeVerifierUtility;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Data
@Service
@RequiredArgsConstructor
public class AuthService
{
    private String codeVerifier;
    public String getAuthorization() throws IOException {
        final var codeVerifier = CodeVerifierUtility.generate();
        setCodeVerifier(codeVerifier);
        ConnectionConfig conn=new ConnectionConfig();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        String scope="ugc-image-upload,user-read-playback-state,user-modify-playback-state,user-read-currently-playing,streaming,app-remote-control,user-read-email,user-read-private,playlist-read-collaborative,playlist-modify-public,playlist-read-private,playlist-modify-private,user-library-modify,user-library-read,user-top-read,user-read-playback-position,user-read-recently-played,user-follow-read,user-follow-modify";
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(conn.getAuth_Url())
                .queryParam("client_id",conn.getClient_id())
                .queryParam("response_type", "code")
                .queryParam("redirect_uri", conn.getRedirect_Url())
                .queryParam("scope",scope)
                .queryParam("state","mystring")
                .encode()
                .toUriString();
        return urlTemplate;

    }
}
