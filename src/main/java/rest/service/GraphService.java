package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.CursoredList;
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

    public void createGraph(List<TwitterProfile> users){
        graph = new Graph();
        for(TwitterProfile i:users){
            //List<Long> friendsId = twitterService.getTwitterFriendsIdByTwitterProfile(i);
            for(TwitterProfile j:users){
                if(i.getId() == j.getId()){
                    continue;
                }

                if(twitterService.hasConnection(twitterService.getFriendshipBeetwen(i, j))){
                    graph.addEdge(i, j);
                }
            }
        }
    }

    public Graph getGraph() {
        return this.graph;
    }

}
