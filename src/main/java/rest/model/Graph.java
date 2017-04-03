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
    private List<Integer>[] connectionList; //lista sasiedztwa

    public Graph(int v) {
        this.v = v;
        e = 0;
        connectionList = new List[v];
        for(int i = 0; i < v; i++){
            connectionList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to){
        if(!connectionList[from].contains(to)) {
            connectionList[from].add(to);
            connectionList[to].add(from);
            e++;
        }
    }

    public int getNumberOfEdges() {
        return e;
    }

    public int getNumberOfVertices() {
        return v;
    }

    public List<Integer>[] getConnectionList() {
        return connectionList;
    }
}
