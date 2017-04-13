package rest.model.csv;

import org.springframework.social.twitter.api.Tweet;
import rest.model.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpe on 13.04.2017.
 */
public class NodeCSV {
    private long id;
    private String text;
    private long userId;
    private int retweetedCount;
    private String tags;
    private int tagsCount;
    private String userName;
    private int friendsCount;
    private int followersCount;

    public NodeCSV(long id, String text, long userId, int retweetedCount, String tags, int tagsCount, String userName, int friendsCount, int followersCount) {
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.retweetedCount = retweetedCount;
        this.tags = tags;
        this.tagsCount = tagsCount;
        this.userName = userName;
        this.friendsCount = friendsCount;
        this.followersCount = followersCount;
    }

    public List<String> getAsList(){
        List<String> nodeList = new ArrayList<>();
        nodeList.add(String.valueOf(id));
        nodeList.add(text);
        nodeList.add(String.valueOf(userId));
        nodeList.add(String.valueOf(retweetedCount));
        nodeList.add(tags);
        nodeList.add(String.valueOf(tagsCount));
        nodeList.add(userName);
        nodeList.add(String.valueOf(friendsCount));
        nodeList.add(String.valueOf(followersCount));
        return nodeList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getRetweetedCount() {
        return retweetedCount;
    }

    public void setRetweetedCount(int retweetedCount) {
        this.retweetedCount = retweetedCount;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getTagsCount() {
        return tagsCount;
    }

    public void setTagsCount(int tagsCount) {
        this.tagsCount = tagsCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }
}
