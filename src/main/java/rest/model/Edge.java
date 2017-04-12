package rest.model;

import org.springframework.social.twitter.api.Tweet;

/**
 * Created by Marr on 2017-04-04.
 */
public class Edge {
    private Tweet from;
    private Tweet to;
    private int weight;

    public Edge(Tweet from, Tweet to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Tweet getFrom() {
        return this.from;
    }

    public void setFrom(Tweet from) {
        this.from = from;
    }

    public Tweet getTo() {
        return this.to;
    }

    public void setTo(Tweet to) {
        this.to = to;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
