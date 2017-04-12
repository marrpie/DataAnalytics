package rest.model.dto;

/**
 * Created by Marr on 2017-04-04.
 */
public class TargetRelationshipDTO {
    private long id;
    private String id_str;
    private String screen_name;
    private boolean following;
    private boolean followed_by;
    private String following_received;
    private String following_requested;

    public TargetRelationshipDTO() {
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
}
