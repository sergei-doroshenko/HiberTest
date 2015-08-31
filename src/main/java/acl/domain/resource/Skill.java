package acl.domain.resource;

/**
 * Created by Sergei on 16.07.2015.
 */
public class Skill {
    private Long id;
    private SkillType type;
    private Long resourceId;

    public Skill() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "{" + id + ", " + type + '}';
    }
}
