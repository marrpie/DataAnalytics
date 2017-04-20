package rest.model.csv;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marr on 2017-04-21.
 */
public class HashEdgeCSV {
    private String source;
    private String target;
    private String type;
    private String text;
    private double sentiment;
    private int retweetCount;
    private int favouriteCount;
    private String userName;
    private String userLocation;
    private String userLang;
    private int userFollowers;
    private int userFriends;

    public HashEdgeCSV(String source, String target, String type, String text, double sentiment, int retweetCount, int favouriteCount, String userName, String userLocation, String userLang, int userFollowers, int userFriends) {
        this.source = source;
        this.target = target;
        this.type = type;
        this.text = text;
        this.sentiment = sentiment;
        this.retweetCount = retweetCount;
        this.favouriteCount = favouriteCount;
        this.userName = userName;
        this.userLocation = userLocation;
        this.userLang = userLang;
        this.userFollowers = userFollowers;
        this.userFriends = userFriends;
    }

    public List<String> getAsList(){
        List<String> edgeList = new ArrayList<>();
        edgeList.add(source);
        edgeList.add(target);
        edgeList.add(type);
        edgeList.add(text);
        edgeList.add(String.valueOf(sentiment));
        edgeList.add(String.valueOf(retweetCount));
        edgeList.add(String.valueOf(favouriteCount));
        edgeList.add(userName);
        edgeList.add(userLocation);
        edgeList.add(userLang);
        edgeList.add(String.valueOf(userFollowers));
        edgeList.add(String.valueOf(userFriends));
        return edgeList;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getSentiment() {
        return sentiment;
    }

    public void setSentiment(double sentiment) {
        this.sentiment = sentiment;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public int getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(int favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserLang() {
        return userLang;
    }

    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }

    public int getUserFollowers() {
        return userFollowers;
    }

    public void setUserFollowers(int userFollowers) {
        this.userFollowers = userFollowers;
    }

    public int getUserFriends() {
        return userFriends;
    }

    public void setUserFriends(int userFriends) {
        this.userFriends = userFriends;
    }
}
