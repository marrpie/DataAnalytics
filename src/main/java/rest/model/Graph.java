package rest.model;

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

    public void addEdge(TwitterProfile i, TwitterProfile j){
        if(!isEdge(i, j)){
            connectionList.add(new Edge(i, j));
            e++;
            if(!isVertices(i)) v++;
            if(!isVertices(j)) v++;
        }
    }

    public Boolean isVertices(TwitterProfile profile){
        for(Edge edge:connectionList){
            if(edge.getFrom().getId() == profile.getId() || edge.getTo().getId() == profile.getId()){
                return true;
            }
        }
        return false;
    }

    public Boolean isEdge(TwitterProfile i, TwitterProfile j){
        for(Edge edge:connectionList){
            if((edge.getFrom().getId() == i.getId() && edge.getTo().getId() == j.getId()) || (edge.getTo().getId() == i.getId() && edge.getFrom().getId() == j.getId())){
                return true;
            }
        }
        return false;
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
