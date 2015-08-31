package acl.domain.filter;

import acl.domain.resource.Skill;

import java.util.List;

/**
 * Created by Sergei on 16.07.2015.
 */
public class ResFilter {
    private List<Long> ids;
    private List<Long> skills;

    public ResFilter() {
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getSkills() {
        return skills;
    }

    public void setSkills(List<Long> skills) {
        this.skills = skills;
    }
}
