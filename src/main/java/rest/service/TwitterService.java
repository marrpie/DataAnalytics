package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marr on 2017-04-03.
 */

@Component
public class TwitterService {

    @Autowired
    private Twitter twitter;

    public List<Tweet> getTweetsByHashTag(String hashTag, int limit){
        return twitter.searchOperations().search(hashTag, limit).getTweets();
    }

    public List<TwitterProfile> getTwitterProfileByTweets(List<Tweet> tweets){
        return tweets.stream().map(tweet -> tweet.getUser()).collect(Collectors.toList());
    }

    public List<Long> getTwitterFriendsIdByTwitterProfile(TwitterProfile user){
        return twitter.friendOperations().getFriendIds(user.getId());
    }
}
