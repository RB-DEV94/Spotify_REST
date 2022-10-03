package com.app.Spotify.Controller;



import com.app.Spotify.Config.ConnectionConfig;
import com.app.Spotify.Service.AlbumsService;
import com.app.Spotify.Service.AuthService;
import com.app.Spotify.Service.TokenService;
import com.app.Spotify.Service.TracksService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Controller
public class SpotifyController
{

    @Autowired
    ConnectionConfig conn;

    @Autowired
    AuthService auth;


    @Autowired
    TokenService tok;

    @Autowired
    AlbumsService album;

    @Autowired
    TracksService track;

    private String access;


        @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
        public String showIndex(final Model model) throws IOException {
            model.addAttribute("url", auth.getAuthorization());
            System.out.println(model.getAttribute("url"));
            return "index";
        }

        @GetMapping(value= "/callback",produces = MediaType.TEXT_HTML_VALUE)
    public String handleCallback( final String code,
                                final HttpSession session,Model model) throws IOException, JSONException {


        session.setAttribute("code", code);
        System.out.println(code);

        access=tok.getToken(code);


        return "home";
    }
   @GetMapping(value = "/albums", produces = MediaType.TEXT_HTML_VALUE)
    public String savedAlbums(final HttpSession session, final Model model) throws JSONException, IOException {

            model.addAttribute("albums", album.getAlbums(access));

            return "hello";
    }
    @GetMapping(value = "/tracks", produces = MediaType.TEXT_HTML_VALUE)
    public String savedAlbums(final Model model) throws JSONException, IOException {

        model.addAttribute("tracks", track.getTracks(access));

        return "tracks";
    }

    @GetMapping(value ="/logout", produces = MediaType.TEXT_HTML_VALUE)
    public String logoutHandler(final HttpSession session) {
        session.invalidate();
        return "redirect:/?logout";
    }
}
