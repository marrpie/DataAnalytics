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
import rest.service.FileService;
import rest.service.GraphService;
import rest.service.TwitterService;

import java.io.IOException;
import java.util.List;
import java.util.Set;
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

    @RequestMapping (value = "/search/tweet/{hashTag}/{limit}", produces = "application/json", method = RequestMethod.GET)
    public String getTweetsByHash(@PathVariable String hashTag, @PathVariable int limit){
        List<Tweet> tweets = twitterService.getTweetsByHashTag("#" + hashTag, limit);

        graphService.createGraph(tweets, 1);
        Graph graph = graphService.getGraph();

        String nodeFile = "C:/Projekty/DataAnalytics/nodes.csv";
        String edgeFile = "C:/Projekty/DataAnalytics/edges.csv";

        try{
            fileService.generateNodeCSVFile(nodeFile, graph);
            fileService.generateEdgeCSVFile(edgeFile, graph);

            return "Generete two new files: \n\n " + nodeFile + "\n" + edgeFile;
        } catch(IOException e){
            System.out.println("Exception during generation CSV files");
            return "Exception during generation CSV files";
        }
    }

}

