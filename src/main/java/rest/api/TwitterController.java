package rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.service.GraphService;
import rest.service.TwitterService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Marr on 2017-03-27.
 */

@RestController
@RequestMapping("/data")
public class TwitterController {

    @Autowired
    private TwitterService twitterService;
    @Autowired
    private GraphService graphService;

    @RequestMapping (value = "/search/user/{hashTag}", produces = "application/json", method = RequestMethod.GET)
    public List<TwitterProfile> getTweetsByHash(@PathVariable String hashTag){
        List<Tweet> tweets = twitterService.getTweetsByHashTag(hashTag, 15);
        Set<TwitterProfile> users = twitterService.getTwitterProfileByTweets(tweets);

        //twitterService.getFriendshipBeetwen(users.get(0), users.get(1));
        //graphService.createGraph(users);
        //graphService.toString();
        return null;
    }

}

