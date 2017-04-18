package rest.model.database;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by mpe on 18.04.2017.
 */
@Entity
public class TweetDB {
    @GeneratedValue
    @Id
    private long id;
    @Column(name = "tweetid")
    private long tweetId;
    @Column
    private String text;
    @Column(name = "createdat")
    private Date createdAt;
    @Column(name = "fromuser")
    private String fromUser;
    @Column(name = "profileimageurl")
    private String profileImageUrl;
    @Column(name = "touserid")
    private long toUserId;
    @Column(name = "fromuserid")
    private long fromUserId;
    @Column(name = "languagecode")
    private String languageCode;
    @Column
    private String source;

    public TweetDB(long tweetId, String text, Date createdAt, String fromUser, String profileImageUrl, long toUserId, long fromUserId, String languageCode, String source) {
        this.tweetId = tweetId;
        this.text = text;
        this.createdAt = createdAt;
        this.fromUser = fromUser;
        this.profileImageUrl = profileImageUrl;
        this.toUserId = toUserId;
        this.fromUserId = fromUserId;
        this.languageCode = languageCode;
        this.source = source;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
