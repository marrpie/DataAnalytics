package rest.model;

import org.springframework.social.twitter.api.TwitterProfile;

/**
 * Created by Marr on 2017-04-04.
 */
public class Edge {
    private TwitterProfile from;
    private TwitterProfile to;

    public Edge(TwitterProfile from, TwitterProfile to) {
        this.from = from;
        this.to = to;
    }

    public TwitterProfile getFrom() {
        return this.from;
    }

    public void setFrom(TwitterProfile from) {
        this.from = from;
    }

    public TwitterProfile getTo() {
        return this.to;
    }

    public void setTo(TwitterProfile to) {
        this.to = to;
    }
}
