package rest.model.dto;

/**
 * Created by Marr on 2017-04-04.
 */
public class RelationshipDTO {
    private TargetRelationshipDTO target;
    private SourceRelationshipDTO source;

    public RelationshipDTO() {
    }

    public TargetRelationshipDTO getTarget() {
        return this.target;
    }

    public void setTarget(TargetRelationshipDTO target) {
        this.target = target;
    }

    public SourceRelationshipDTO getSource() {
        return this.source;
    }

    public void setSource(SourceRelationshipDTO source) {
        this.source = source;
    }
}
