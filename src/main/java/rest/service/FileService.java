package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;
import rest.model.HashEdge;
import rest.model.HashGraph;
import rest.model.csv.HashEdgeCSV;
import rest.model.sentiment.SentimentObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
