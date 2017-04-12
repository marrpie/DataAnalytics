package rest.model;

import org.springframework.social.twitter.api.HashTagEntity;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marr on 2017-04-03.
 */
public class Graph {
    private int e; //liczba krawedzi
    private int v; //liczba wierzcholkow
    private List<Edge> connectionList; //lista sasiedztwa

    public Graph() {
        v = 0;
        e = 0;
        connectionList = new ArrayList<>();
    }

    public void addEdge(Tweet i, Tweet j){
        if(!isEdge(i, j)){
            int weight = findWeight(i,j);
            connectionList.add(new Edge(i, j, weight));
            e++;
            if(!isVertices(i)) v++;
            if(!isVertices(j)) v++;
        }
    }

    public Boolean isVertices(Tweet tweet){
        for(Edge edge:connectionList){
            if(edge.getFrom().getId() == tweet.getId() || edge.getTo().getId() == tweet.getId()){
                return true;
            }
        }
        return false;
    }

    public Boolean isEdge(Tweet i, Tweet j){
        for(Edge edge:connectionList){
            if((edge.getFrom().getId() == i.getId() && edge.getTo().getId() == j.getId()) || (edge.getTo().getId() == i.getId() && edge.getFrom().getId() == j.getId())){
                return true;
            }
        }
        return false;
    }

    public int findWeight(Tweet i, Tweet j){
        List<HashTagEntity> firstNodeTags = i.getEntities().getHashTags();
        List<HashTagEntity> secondNodeTags = i.getEntities().getHashTags();
        int weight = 0;
        for(HashTagEntity first:firstNodeTags){
            for(HashTagEntity second:secondNodeTags){
                if(first.equals(second)){
                    weight++;
                }
            }
        }
        return weight;
    }

    public int getNumberOfEdges() {
        return e;
    }

    public int getNumberOfVertices() {
        return v;
    }

    public List<Edge> getConnectionList() {
        return connectionList;
    }
}
