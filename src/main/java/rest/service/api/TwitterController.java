package rest.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marr on 2017-03-27.
 */

@RestController
@RequestMapping("/data")
public class TwitterController {

    @Autowired
    private Twitter twitter;

    @RequestMapping (value = "/hash/{hashTag}", produces = "application/json", method = RequestMethod.GET)
    public List<Tweet> getUsersByHash(@PathVariable String hashTag){
        return twitter.searchOperations().search(hashTag, 20).getTweets();
    }

    @RequestMapping (value = "/example", produces = "application/json")
    public String getUsersByHash(){
        return "koza";
    }
}

