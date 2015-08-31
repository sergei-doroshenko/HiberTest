package acl.domain.resource;

import java.util.Collection;

/**
 * Created by Sergei on 16.07.2015.
 */
public class Resource {
    private Long id;
    private String name;
    private transient Collection<Skill> skills;

    public Resource() {
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

    public Collection<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Collection<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Resource{" + id + ", " + name +
                ", skills:" + skills +
                '}';
    }
}
