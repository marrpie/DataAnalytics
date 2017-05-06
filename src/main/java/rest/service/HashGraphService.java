package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Entities;
import org.springframework.social.twitter.api.GeoCode;
import org.springframework.social.twitter.api.HashTagEntity;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;
import rest.model.HashGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Marr on 2017-04-20.
 */
@Component
public class HashGraphService {

    private HashGraph hashGraph;

    @Autowired
    TwitterService twitterService;

    public HashGraph createHashGraph(List<String> tags, GeoCode geoCode){
        hashGraph = new HashGraph();
        List<Tweet> tweets = twitterService.findTweetsByTagsWithMinHashTags(tags, 2, geoCode);
        Set<String> hashTags = twitterService.getHashForTweets(tweets);

        for(String firstHash:hashTags){
            List<Tweet> tweetList = tweets.stream().filter(tweet -> hasEntitiesHashTag(tweet.getEntities(),firstHash)).collect(Collectors.toList());
            for(Tweet tweet:tweetList){
                for(HashTagEntity fHash:tweet.getEntities().getHashTags()){
                    for(HashTagEntity sHash:tweet.getEntities().getHashTags()){
                        if(!fHash.getText().toLowerCase().equals(sHash.getText().toLowerCase())){
                            hashGraph.addEdge(fHash, sHash, tweet);
                        }
                    }
                }
            }
        }

        return hashGraph;
    }

    private Boolean hasEntitiesHashTag(Entities entities, String hash){
        for(HashTagEntity tag:entities.getHashTags()){
            if(tag.getText().equals(hash)){
                return true;
            }
        }
        return false;
    }
}
