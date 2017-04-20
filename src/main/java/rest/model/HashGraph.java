package rest.model;

import org.springframework.social.twitter.api.HashTagEntity;
import org.springframework.social.twitter.api.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marr on 2017-04-20.
 */
public class HashGraph {
    private List<HashEdge> connectionList; //lista sasiedztwa - krawedzi
    private List<String> vertices; //liczba wierzcholkow

    public HashGraph() {
        connectionList = new ArrayList<>();
        vertices = new ArrayList<>();
    }

    public void addEdge(HashTagEntity source, HashTagEntity target, Tweet edge){
        if(!isEdge(source, target, edge)){
            if(!vertices.contains(source.getText())) vertices.add(source.getText());
            if(!vertices.contains(target.getText())) vertices.add(target.getText());
            connectionList.add(new HashEdge(source.getText(), target.getText(), edge));
        }
    }

    public Boolean isEdge(HashTagEntity source, HashTagEntity target, Tweet edge){
        if(connectionList.size() > 0){
            for(HashEdge e:connectionList){
                if((source.getText().equals(e.getSource()) && target.getText().equals(e.getTarget()) && e.getTweet().getId() == edge.getId()) || (source.getText().equals(e.getTarget()) && target.getText().equals(e.getSource())  && e.getTweet().getId() == edge.getId())){
                    return true;
                }
            }
        }

        return false;
    }

    public List<HashEdge> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<HashEdge> connectionList) {
        this.connectionList = connectionList;
    }

    public List<String> getVertices() {
        return vertices;
    }

    public void setVertices(List<String> vertices) {
        this.vertices = vertices;
    }
}
