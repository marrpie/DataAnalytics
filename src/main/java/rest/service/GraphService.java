package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Component;
import rest.model.Graph;

import java.util.Date;
import java.util.List;

/**
 * Created by Marr on 2017-04-03.
 */
@Component
public class GraphService {
    private Graph graph;

    @Autowired
    private TwitterService twitterService;

    private long ONE_DAY = 86400000;

    public Graph createGraphWithMinNodes(List<Tweet> tweets, int weightType, String hashTag, int min, Date date){
        createGraph(tweets, weightType, hashTag);
        if(graph.getVertices().size() < min){
            date = new Date(date.getTime()+ONE_DAY);
            List<Tweet> newTweets = twitterService.clearTheSameByText(twitterService.getTweetsByHashTag("#" + hashTag, 100, date));
            if(date.after(new Date())){
                return graph;
            }

            createGraphWithMinNodes(newTweets, weightType, hashTag, min, date);
        }
        return graph;
    }

    public void initGraph(){
        graph = new Graph();
    }

    public void createGraph(List<Tweet> tweets, int weightType, String hashTag){
        for(Tweet i:tweets){
            for(Tweet j:tweets){
                if(i.getId() != j.getId()){
                    graph.addEdge(i,j, weightType, hashTag);
                }
            }
        }
    }

    public Graph getGraph() {
        return this.graph;
    }

}
