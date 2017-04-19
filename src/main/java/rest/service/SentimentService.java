package rest.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;
import com.algorithmia.*;
import com.algorithmia.algo.*;
import rest.model.sentiment.SentimentObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marr on 2017-04-17.
 */

@Component
public class SentimentService {

    @Autowired
    TwitterService twitterService;

    private List<SentimentObject> sentimentObjects;

    public double getSentimentByIdFromList(long id, List<SentimentObject> objects){
        for(SentimentObject object:objects){
            if(object.getId() == id){
                return object.getSentiment();
            }
        }

        return -2; //error
    }

    public List<SentimentObject> getSentimentObjects() {
        return sentimentObjects;
    }

    public void setSentimentObjects(List<SentimentObject> sentimentObjects) {
        this.sentimentObjects = sentimentObjects;
    }

    public List<SentimentObject> getSentimentByTexts(List<Tweet> nodes){
        sentimentObjects = new ArrayList<>();

        JSONArray array = generateNodesInJSON(nodes);

        String nodesSentiment = findSentiment(array);

        if(!nodesSentiment.equals("")){
            JSONArray sentiments = new JSONArray(nodesSentiment);
            for(int i=0; i<sentiments.length(); i++){
                JSONObject jsonObject = sentiments.getJSONObject(i);
                String text = jsonObject.getString("document");
                double sentiment = jsonObject.getDouble("sentiment");
                long id = twitterService.findTweetIdInListByText(text, nodes);
                sentimentObjects.add(new SentimentObject(id, text, sentiment));
            }
        }

        return sentimentObjects;
    }

    private JSONArray generateNodesInJSON(List<Tweet> nodes){
        JSONArray array = new JSONArray();
        for(Tweet node:nodes){
            JSONObject object = new JSONObject();
            object.put("document", node.getText());
            array.put(object);
        }

        return array;
    }

    private String findSentiment(JSONArray nodes){
        AlgorithmiaClient client = Algorithmia.client("sim9A+hIFQZqbG065eBFgBbTmV31");
        Algorithm algo = client.algo("algo://nlp/SentimentAnalysis/1.0.3");
        try{
            AlgoResponse result = algo.pipeJson(nodes.toString());
            return result.asJsonString();
        } catch(APIException e){
            return "";
        } catch (AlgorithmException e){
            return "";
        }
    }



}
