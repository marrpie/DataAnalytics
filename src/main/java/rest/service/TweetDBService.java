package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;
import rest.model.database.TweetDB;
import rest.model.sentiment.SentimentObject;
import rest.repository.TweetDBRepository;

import java.util.List;


/**
 * Created by mpe on 18.04.2017.
 */
@Component
public class TweetDBService {

    @Autowired
    TweetDBRepository tweetDBRepository;
    @Autowired
    SentimentService sentimentService;

    public void addTweetToDB(Tweet tweet, String hashTag, List<SentimentObject> sentimentNodes){
        TweetDB tweetDB = new TweetDB(tweet.getId(),
                                    tweet.getText(),
                                    tweet.getCreatedAt(),
                                    tweet.getFromUser(),
                                    tweet.getProfileImageUrl(),
                                    tweet.getToUserId(),
                                    tweet.getFromUserId(),
                                    tweet.getLanguageCode(),
                                    tweet.getSource(),
                                    hashTag,
                                    sentimentService.getSentimentByIdFromList(tweet.getId(), sentimentNodes));

        tweetDBRepository.save(tweetDB);
    }

    public void addTweetsToDB(List<Tweet> tweets, String hashTag, List<SentimentObject> sentimentNodes){
        for(Tweet tweet:tweets){
            addTweetToDB(tweet, hashTag, sentimentNodes);
        }
    }

    public TweetDB getTweetById(long id){
        return tweetDBRepository.findOne(id);
    }

    public TweetDB getTweetByTweetId(long id){
        return tweetDBRepository.findByTweetId(id);
    }

    public Iterable<TweetDB> getAllTweets(){
        return tweetDBRepository.findAll();
    }

}
