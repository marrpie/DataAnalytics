package rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.model.Graph;
import rest.model.HashGraph;
import rest.model.database.TweetDB;
import rest.service.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Marr on 2017-03-27.
 */

@RestController
@RequestMapping("/data")
public class TwitterController {

    @Autowired
    private TwitterService twitterService;
    @Autowired
    private GraphService graphService;
    @Autowired
    private FileService fileService;
    @Autowired
    private TweetDBService tweetDBService;
    @Autowired
    private SentimentService sentimentService;
    @Autowired
    private HashGraphService hashGraphService;

    private long SEVEN_DAYS = 604800000;

    @RequestMapping (value = "/search/tweet/{hashTag}/{limit}", produces = "application/json", method = RequestMethod.GET)
    public String getTweetsByHash(@PathVariable String hashTag, @PathVariable int limit){
        Date date = new Date();
        date = new Date(date.getTime()-SEVEN_DAYS);
        List<Tweet> tweets = twitterService.clearTheSameByText(twitterService.getTweetsByHashTag("#" + hashTag, limit, date));

        graphService.initGraph();
        Graph graph = graphService.createGraphWithMinNodes(tweets, 1, hashTag, 150, date);

        String path = System.getProperty("user.dir");
        String nodeFile = path + "/nodes.csv";
        String edgeFile = path + "/edges.csv";

        try{
            fileService.generateNodeCSVFile(nodeFile, graph);
            fileService.generateEdgeCSVFile(edgeFile, graph);

            //tweetDBService.addTweetsToDB(graph.getVertices(), hashTag, sentimentService.getSentimentObjects());

            return "Generete two new files: \n\n " + nodeFile + "\n" + edgeFile;
        } catch(IOException e){
            System.out.println("Exception during generation CSV files");
            return "Exception during generation CSV files";
        }
    }

    @RequestMapping (value = "/search/tweet/music", produces = "application/json", method = RequestMethod.GET)
    public String getTweetsByHash(){
        List<String> tags = new ArrayList<>();
        tags.add("#pop");
        tags.add("#reagge");
        tags.add("#rap");
        tags.add("#rock");
        tags.add("#blues");
        tags.add("#metal");
        tags.add("#indierock");
        tags.add("#hip-hop");
        tags.add("#folk");
        tags.add("#jazz");


        HashGraph graph = hashGraphService.createHashGraph(tags);

        String path = System.getProperty("user.dir");
        String edgeFile = path + "/music_edges_wlkb.csv";
        //return edgeFile;
        try{
            fileService.generateHashEdgeCSVFile(edgeFile, graph);

            //tweetDBService.addTweetsToDB(graph.getVertices(), hashTag, sentimentService.getSentimentObjects());

            return "Generete new file: \n" + edgeFile;
        } catch(IOException e){
            System.out.println("Exception during generation CSV files");
            return "Exception during generation CSV files";
        }
    }

}

