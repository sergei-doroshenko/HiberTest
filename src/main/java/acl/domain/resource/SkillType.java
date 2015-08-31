package acl.domain.resource;

/**
 * Created by Sergei on 16.07.2015.
 */
public class SkillType {
    private Long id;
    private String name;

    public SkillType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
