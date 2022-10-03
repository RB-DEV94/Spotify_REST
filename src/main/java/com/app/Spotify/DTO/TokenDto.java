package com.app.Spotify.DTO;

import lombok.Data;

@Data
public class TokenDto
{
    private String access_token;
    private String token_type;
    private String expires_in;
    private String refresh_token;
    private String scope;
}
