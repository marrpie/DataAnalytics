package rest.model.csv;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpe on 13.04.2017.
 */
public class EdgeCSV {
    private long from;
    private long to;
    private String type;
    private int weight;

    public EdgeCSV(long from, long to, String type, int weight) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.weight = weight;
    }

    public List<String> getAsList(){
        List<String> edgeList = new ArrayList<>();
        edgeList.add(String.valueOf(from));
        edgeList.add(String.valueOf(to));
        edgeList.add(type);
        edgeList.add(String.valueOf(weight));
        return edgeList;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
