package com.TMDB.TMDBapp.controllers;

import com.TMDB.TMDBapp.models.Actor;
import com.TMDB.TMDBapp.models.Movie;
import com.TMDB.TMDBapp.models.SearchResult;
import com.TMDB.TMDBapp.models.TVShow;
import com.TMDB.TMDBapp.services.TMDbService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@CrossOrigin
public class TMDbController {



    public final String BASE_URL = "https://api.themoviedb.org/3";
    private final String API_KEY = "917369bb118862e487faedc2fa6bf48d"; // need to hide key

    TMDbService tmDbService = new TMDbService(BASE_URL, API_KEY);

    //TEST RUN
    @RequestMapping(path="/test", method = RequestMethod.GET)
    public Actor getTestActor(){
        Actor test = new Actor("url", "actor", 1);
        return test;
    }


    //MULTI SEARCH
    @CrossOrigin
    @RequestMapping(path="/search/multi/{query}", method = RequestMethod.GET)
    public String multiSearch(@PathVariable String query){
        return tmDbService.multiSearch(query);
    }

    //MOVIE SEARCH
    @CrossOrigin
    @RequestMapping(path="/search/movie/{text}/{page}", method = RequestMethod.GET)
    public String movieSearch(@PathVariable String text, @PathVariable int page){

        return tmDbService.movieSearch(text, page);
    }

    //TV SEARCH
    @RequestMapping(path="/search/tv/{query}", method = RequestMethod.GET)
    public String tvSearch(@PathVariable String query){

        return tmDbService.tvSearch(query);
    }

    //ACTOR SEARCH
    @RequestMapping(path="/search/actor/{query}", method = RequestMethod.GET)
    public String actorSearch(@PathVariable String query){

        return tmDbService.actorSearch(query);
    }

}
