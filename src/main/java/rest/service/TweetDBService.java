package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;
import rest.model.database.TweetDB;
import rest.repository.TweetDBRepository;


/**
 * Created by mpe on 18.04.2017.
 */
@Component
public class TweetDBService {

    @Autowired
    TweetDBRepository tweetDBRepository;

    public void addTweetToDB(Tweet tweet){
        TweetDB tweetDB = new TweetDB(tweet.getId(),
                                    tweet.getText(),
                                    tweet.getCreatedAt(),
                                    tweet.getFromUser(),
                                    tweet.getProfileImageUrl(),
                                    tweet.getToUserId(),
                                    tweet.getFromUserId(),
                                    tweet.getLanguageCode(),
                                    tweet.getSource());

        tweetDBRepository.save(tweetDB);
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
