package com.app.Spotify.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class ConnectionConfig
{

    Properties prop=new Properties();

    private String Client_id;

    private String Secret;

    private String redirect_Url;

    private String Auth_Url;

    private String TokenUrl;

    public ConnectionConfig() throws IOException {
        FileInputStream fis=new FileInputStream("/Users/rahulbhagwat/Downloads/Spotify/src/main/resources/application.properties");
        prop.load(new FileInputStream("/Users/rahulbhagwat/Downloads/Spotify/src/main/resources/application.properties"));
    }


    public String getAuth_Url() {
        Auth_Url= prop.getProperty("auth_url");
        return Auth_Url;
    }

    public String getSecret() {
        Secret= prop.getProperty("app.Secret");
        return Secret;
    }
    public String getTokenUrl() {
        TokenUrl= prop.getProperty("accesstokenURL");
        return TokenUrl;
    }

    public String getRedirect_Url() {
        redirect_Url= prop.getProperty("app.redirectURL");
        return redirect_Url;
    }

    public String getClient_id() {
        Client_id= prop.getProperty("app.client");
        return Client_id;
    }
}
