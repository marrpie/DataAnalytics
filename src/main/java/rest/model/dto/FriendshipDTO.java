package rest.model.dto;

/**
 * Created by Marr on 2017-04-04.
 */
public class FriendshipDTO {
    private RelationshipDTO relationship;

    public FriendshipDTO() {
    }

    public RelationshipDTO getRelationship() {
        return this.relationship;
    }

    public void setRelationship(RelationshipDTO relationship) {
        this.relationship = relationship;
    }
}
