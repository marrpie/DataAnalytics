package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Component;
import rest.model.Edge;
import rest.model.Graph;
import rest.model.HashEdge;
import rest.model.HashGraph;
import rest.model.csv.EdgeCSV;
import rest.model.csv.HashEdgeCSV;
import rest.model.csv.NodeCSV;
import rest.model.sentiment.SentimentObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Marr on 2017-04-10.
 */
@Component
public class FileService {

    @Autowired
    CSVService csvService;
    @Autowired
    SentimentService sentimentService;

    public void generateEdgeCSVFile(String name, Graph graph) throws IOException{
        List<Edge> edges = graph.getConnectionList();
        List<EdgeCSV> edgesCSV = new ArrayList<>();

        for(Edge edge:edges){
            edgesCSV.add(new EdgeCSV(edge.getFrom().getId(),
                                    edge.getTo().getId(),
                                    "Undirected",
                                    edge.getWeight()));
        }

        csvService.generateEdgeFile(name,edgesCSV);
    }

    public void generateNodeCSVFile(String name, Graph graph) throws IOException{
        List<Tweet> nodes = graph.getVertices();
        List<NodeCSV> nodesCSV = new ArrayList<>();

        List<SentimentObject> sentimentNodes = sentimentService.getSentimentByTexts(nodes);

        for(Tweet tweet:nodes){
            nodesCSV.add(new NodeCSV(tweet.getId(),
                                    tweet.getText(),
                                    sentimentService.getSentimentByIdFromList(tweet.getId(), sentimentNodes),
                                    tweet.getUser().getId(),
                                    tweet.getRetweetCount(),
                                    tweet.getEntities().getHashTags().stream().map(tag -> "#" + tag.getText()).collect(Collectors.toList()).toString(),
                                    tweet.getEntities().getHashTags().size(),
                                    tweet.getUser().getName(),
                                    tweet.getUser().getFriendsCount(),
                                    tweet.getUser().getFollowersCount()));
        }

        csvService.generateNodeFile(name, nodesCSV);
    }

    public void generateHashEdgeCSVFile(String name, HashGraph graph) throws IOException{
        List<HashEdge> edges = graph.getConnectionList();
        List<HashEdgeCSV> edgesCSV = new ArrayList<>();

        List<Tweet> tweets = new ArrayList<>(edges.stream().map(HashEdge::getTweet).collect(Collectors.toSet()));
        List<SentimentObject> sentimentNodes = sentimentService.getSentimentByTexts(tweets);

        for(HashEdge edge:edges){
            edgesCSV.add(
                    new HashEdgeCSV(
                            edge.getSource(),
                            edge.getTarget(),
                            "Undirected",
                            edge.getTweet().getText(),
                            sentimentService.getSentimentByIdFromList(edge.getTweet().getId(), sentimentNodes),
                            edge.getTweet().getRetweetCount(),
                            edge.getTweet().getFavoriteCount(),
                            edge.getTweet().getUser().getName(),
                            edge.getTweet().getUser().getLocation(),
                            edge.getTweet().getUser().getLanguage(),
                            edge.getTweet().getUser().getFollowersCount(),
                            edge.getTweet().getUser().getFriendsCount()
                    )
            );
        }

        csvService.generateHashEdgeFile(name,edgesCSV);
    }

}
