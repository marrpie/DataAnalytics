package rest.repository;

import org.springframework.data.repository.CrudRepository;
import rest.model.database.TweetDB;

import java.util.List;

/**
 * Created by mpe on 18.04.2017.
 */
public interface TweetDBRepository extends CrudRepository<TweetDB, Long>{
    public TweetDB findByTweetId(long tweetId);
}
