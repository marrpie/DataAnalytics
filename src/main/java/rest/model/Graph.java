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
    private List<Edge> connectionList; //lista sasiedztwa - krawedzi
    private List<Tweet> vertices; //liczba wierzcholkow

    public Graph() {
        vertices = new ArrayList<>();
        connectionList = new ArrayList<>();
    }

    public void addEdge(Tweet i, Tweet j, int weightType, String hashTag){
        int weight = findWeight(i,j, weightType, hashTag);
        if(!isEdge(i, j) && weight > 0){
            if(!isVertices(i)) vertices.add(i);
            if(!isVertices(j)) vertices.add(j);
            connectionList.add(new Edge(i, j, weight));
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

    public int findWeight(Tweet i, Tweet j, int weightType, String hashTag){
        int weight = 0;
        switch (weightType){
            case 1: //po ilosci hashTagow
                weight = findWeightByHashTag(i, j, hashTag);
                break;
            default:
                weight = findWeightByHashTag(i, j, hashTag);
                break;
        }

        return weight;
    }

    public int findWeightByHashTag(Tweet i, Tweet j, String hashTag){
        List<HashTagEntity> firstNodeTags = i.getEntities().getHashTags();
        List<HashTagEntity> secondNodeTags = j.getEntities().getHashTags();
        int weight = 0;
        for(HashTagEntity first:firstNodeTags){
            for(HashTagEntity second:secondNodeTags){
                if(!first.getText().toLowerCase().equals(hashTag.toLowerCase()) && first.getText().toLowerCase().equals(second.getText().toLowerCase())){
                    weight++;
                }
            }
        }
        return weight;
    }

    public int getNumberOfEdges() {
        return connectionList.size();
    }

    public int getNumberOfVertices() {
        return vertices.size();
    }

    public List<Tweet> getVertices() {
        return vertices;
    }

    public List<Edge> getConnectionList() {
        return connectionList;
    }
}
