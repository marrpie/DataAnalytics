package rest.model.dto;

/**
 * Created by Marr on 2017-04-04.
 */
public class SourceRelationshipDTO {
    private long id;
    private String id_str;
    private String screen_name;
    private boolean following;
    private boolean followed_by;
    private boolean live_following;
    private String following_received;
    private String following_requested;
    private String notifications_enabled;
    private boolean can_dm;
    private boolean blocking;
    private boolean blocked_by;
    private String muting;
    private String want_retweets;
    private String all_replies;
    private String marked_spam;

    public SourceRelationshipDTO() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getId_str() {
        return this.id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public String getScreen_name() {
        return this.screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public boolean isFollowing() {
        return this.following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public boolean isFollowed_by() {
        return this.followed_by;
    }

    public void setFollowed_by(boolean followed_by) {
        this.followed_by = followed_by;
    }

    public boolean isLive_following() {
        return this.live_following;
    }

    public void setLive_following(boolean live_following) {
        this.live_following = live_following;
    }

    public String getFollowing_received() {
        return this.following_received;
    }

    public void setFollowing_received(String following_received) {
        this.following_received = following_received;
    }

    public String getFollowing_requested() {
        return this.following_requested;
    }

    public void setFollowing_requested(String following_requested) {
        this.following_requested = following_requested;
    }

    public String getNotifications_enabled() {
        return this.notifications_enabled;
    }

    public void setNotifications_enabled(String notifications_enabled) {
        this.notifications_enabled = notifications_enabled;
    }

    public boolean isCan_dm() {
        return this.can_dm;
    }

    public void setCan_dm(boolean can_dm) {
        this.can_dm = can_dm;
    }

    public boolean isBlocking() {
        return this.blocking;
    }

    public void setBlocking(boolean blocking) {
        this.blocking = blocking;
    }

    public boolean isBlocked_by() {
        return this.blocked_by;
    }

    public void setBlocked_by(boolean blocked_by) {
        this.blocked_by = blocked_by;
    }

    public String getMuting() {
        return this.muting;
    }

    public void setMuting(String muting) {
        this.muting = muting;
    }

    public String getWant_retweets() {
        return this.want_retweets;
    }

    public void setWant_retweets(String want_retweets) {
        this.want_retweets = want_retweets;
    }

    public String getAll_replies() {
        return this.all_replies;
    }

    public void setAll_replies(String all_replies) {
        this.all_replies = all_replies;
    }

    public String getMarked_spam() {
        return this.marked_spam;
    }

    public void setMarked_spam(String marked_spam) {
        this.marked_spam = marked_spam;
    }
}
