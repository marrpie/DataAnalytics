package rest.model;

import org.springframework.social.twitter.api.Tweet;

/**
 * Created by Marr on 2017-04-20.
 */
public class HashEdge {
    private String Source;
    private String Target;
    private Tweet tweet;

    public HashEdge(String source, String target, Tweet tweet) {
        Source = source;
        Target = target;
        this.tweet = tweet;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getTarget() {
        return Target;
    }

    public void setTarget(String target) {
        Target = target;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
}
