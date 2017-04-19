package rest.service;

import org.springframework.stereotype.Component;
import rest.model.csv.EdgeCSV;
import rest.model.csv.NodeCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by mpe on 13.04.2017.
 */
@Component
public class CSVService {
    private char SEPARATOR = '|';

    private String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        if(result.contains("\n")){
            result = result.replaceAll("\\n", " ");
        }
        return result;

    }

    private void writeLine(Writer w, List<String> values) throws IOException {

        boolean first = true;

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(SEPARATOR);
            }
            sb.append(followCVSformat(value));

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());


    }

    private void writeEdgeHeaders(Writer w) throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append("from");
        sb.append("|");
        sb.append("to");
        sb.append("|");
        sb.append("weight");

        sb.append("\n");
        w.append(sb.toString());
    }

    private void writeNodeHeaders(Writer w) throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append("id");
        sb.append("|");
        sb.append("text");
        sb.append("|");
        sb.append("sentiment");
        sb.append("|");
        sb.append("userId");
        sb.append("|");
        sb.append("retweetedCount");
        sb.append("|");
        sb.append("tags");
        sb.append("|");
        sb.append("tagsCount");
        sb.append("|");
        sb.append("userName");
        sb.append("|");
        sb.append("friendsCount");
        sb.append("|");
        sb.append("followersCount");

        sb.append("\n");
        w.append(sb.toString());
    }

    public void generateNodeFile(String file, List<NodeCSV> nodes) throws IOException{
        FileWriter writer = new FileWriter(file);

        writeNodeHeaders(writer);

        for(NodeCSV node:nodes){
            writeLine(writer, node.getAsList());
        }

        writer.flush();
        writer.close();

    }

    public void generateEdgeFile(String file, List<EdgeCSV> edges) throws IOException{
        FileWriter writer = new FileWriter(file);

        writeEdgeHeaders(writer);

        for(EdgeCSV edge:edges){
            writeLine(writer, edge.getAsList());
        }

        writer.flush();
        writer.close();

    }
}
