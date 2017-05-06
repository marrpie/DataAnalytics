package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.RateLimitExceededException;
import org.springframework.social.twitter.api.*;
import org.springframework.stereotype.Component;
import rest.model.dto.FriendshipDTO;
import rest.model.dto.RelationshipDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Marr on 2017-04-03.
 */

@Component
public class TwitterService {

    @Autowired
    private Twitter twitter;

    public List<Tweet> getTweetsByHashTag(String hashTag, int limit, Date date){
        SearchParameters searchParameters = new SearchParameters(hashTag);
        searchParameters.lang("en");
        searchParameters.count(limit);
        searchParameters.until(date);
        return twitter.searchOperations().search(searchParameters).getTweets();
    }

    public List<Tweet> getTweetsByHashTag(String hashTag, int limit, GeoCode geoCode){
        SearchParameters searchParameters = new SearchParameters(hashTag);
        searchParameters.lang("en");
        searchParameters.geoCode(geoCode);
        searchParameters.count(limit);
        return twitter.searchOperations().search(searchParameters).getTweets();
    }

    public List<Tweet> clearByMinTags(List<Tweet> tweets, int min){
        List<Tweet> result = clearTheSameByText(tweets);

        result.stream().filter(tweet -> tweet.getEntities().getHashTags().size() > min).collect(Collectors.toList());

        return result;
    }

    public Set<HashTagEntity> getHashForTweets(List<Tweet> tweets){
        Set<HashTagEntity> hashTags = new HashSet<>();
        for(Tweet tweet:tweets){
            for(HashTagEntity hash:tweet.getEntities().getHashTags()){
                hashTags.add(hash);
            }
        }
        return hashTags;
    }

    public List<Tweet> findTweetsByTagsWithMinHashTags(List<String> tags, int min, GeoCode geoCode){
        List<Tweet> tweets = new ArrayList<>();

        for(String tag:tags){
            List<Tweet> tweetsForTag = clearByMinTags(getTweetsByHashTag(tag, 50, geoCode), min);
            tweets.addAll(tweetsForTag);
        }

        return tweets;
    }

    public long findTweetIdInListByText(String text, List<Tweet> tweets){
        for(Tweet tweet:tweets){
            if(tweet.getText().toLowerCase().equals(text.toLowerCase())){
                return tweet.getId();
            }
        }

        return -1L;
    }

    public List<Tweet> clearTheSameByText(List<Tweet> tweets){
        Set<Long> idsToRemove = new HashSet<>();
        for(int i=0; i<tweets.size(); i++){
            for(int j=0; j<tweets.size(); j++){
                if(tweets.get(i).getText().toLowerCase().equals(tweets.get(j).getText().toLowerCase()) && tweets.get(i).getId() != tweets.get(j).getId()){
                    idsToRemove.add(tweets.get(j).getId());
                }
            }
        }

        if(idsToRemove.size() > 0){
            for(Long id:idsToRemove){
                if(tweets.stream().filter(t -> t.getId() == id).findFirst().isPresent()){
                    Tweet tweet = tweets.stream().filter(t -> t.getId() == id).findFirst().get();
                    tweets.remove(tweet);
                }
            }
        }

        return tweets;
    }

    public Set<TwitterProfile> getTwitterProfileByTweets(List<Tweet> tweets){
        return tweets.stream().map(tweet -> tweet.getUser()).collect(Collectors.toSet());
    }

    public List<Long> getTwitterFriendsIdByTwitterProfile(TwitterProfile user){
        List<Long> friendsId = new ArrayList<Long>();
        try{
            friendsId = twitter.friendOperations().getFriendIds(user.getId());
        } catch(RateLimitExceededException e){

        }
        return friendsId;
    }

    public FriendshipDTO getFriendshipBeetwen(TwitterProfile i, TwitterProfile j){
        String url = "https://api.twitter.com/1.1/friendships/show.json?source_id=" + i.getId() + "&target_id=" + j.getId();
        try {
            URI uri = new URI(url);
            FriendshipDTO friendshipDTO =  twitter.restOperations().getForObject(uri, FriendshipDTO.class);
            return friendshipDTO;
        } catch(URISyntaxException uriException){
            return null;
        }
    }

    public Boolean hasConnection(FriendshipDTO friendshipDTO){
        if(friendshipDTO == null){
            return false;
        }

        RelationshipDTO relationshipDTO = friendshipDTO.getRelationship();
        if(relationshipDTO.getSource().isFollowed_by() || relationshipDTO.getSource().isFollowing()){
            return true;
        }

        if(relationshipDTO.getTarget().isFollowing() || relationshipDTO.getTarget().isFollowed_by()){
            return true;
        }

        return false;
    }
}
