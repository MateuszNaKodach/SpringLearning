package pl.nowakprojects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mateusz on 09.04.2017.
 */
@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    private Twitter twitter;

    @RequestMapping("/find")
    public String hello(
            @RequestParam(defaultValue = "Papież Franciszek") String search,
            Model model
            ){
        SearchResults searchResults = twitter.searchOperations().search(search);

        List<Tweet> tweets = searchResults.getTweets();

        model.addAttribute("tweets",tweets);
        model.addAttribute("search",search);
        return "resultPage";
    }
}
