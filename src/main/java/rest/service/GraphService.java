package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void createGraph(int numbersOfVertices){
        graph = new Graph(numbersOfVertices);
    }

    public void createGraph(List<TwitterProfile> users){
        graph = new Graph(users.size());
        for(TwitterProfile i:users){
            List<Long> friendsId = twitterService.getTwitterFriendsIdByTwitterProfile(i);
            for(TwitterProfile j:users){
                if(i.getId() == j.getId()){
                    continue;
                }

                if(friendsId.contains(j.getId())){
                    graph.addEdge((int)i.getId(), (int)j.getId());
                }
            }
        }
    }

    public Graph getGraph() {
        return this.graph;
    }

    @Override
    public String toString() {
        List<Integer>[] connectionList = graph.getConnectionList();
        StringBuilder str = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        str.append("Wierzcholki: ").append("; Krawedzie: ").append(graph.getNumberOfEdges()).append(newLine);
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            str.append(i).append(": ");
            for (int w : connectionList[i]) {
                str.append(w).append(" ");
            }
            str.append(newLine);
        }
        return str.toString();
    }
}
