package rest.model.csv;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpe on 13.04.2017.
 */
public class EdgeCSV {
    private long from;
    private long to;
    private int weight;

    public EdgeCSV(long from, long to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public List<String> getAsList(){
        List<String> edgeList = new ArrayList<>();
        edgeList.add(String.valueOf(from));
        edgeList.add(String.valueOf(to));
        edgeList.add(String.valueOf(weight));
        return edgeList;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
