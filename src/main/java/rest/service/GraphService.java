package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Component;
import rest.model.Graph;

import java.util.List;

/**
 * Created by Marr on 2017-04-03.
 */
@Component
public class GraphService {
    private Graph graph;

    @Autowired
    private TwitterService twitterService;

    public void createGraph(List<Tweet> tweets, int weightType, String hashTag){
        graph = new Graph();
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
