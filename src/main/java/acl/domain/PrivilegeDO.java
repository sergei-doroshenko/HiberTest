package acl.domain;

import java.util.Set;

/**
 * Created by Sergei on 22.06.2015.
 */
public class PrivilegeDO extends DomainObject {
    private String description;
    private Set<GroupDO> groups;

    public PrivilegeDO() {
    }

    public PrivilegeDO(Long id, String name, String description, Set<GroupDO> groups) {
        super(id, name);
        this.description = description;
        this.groups = groups;
    }

    public Set<GroupDO> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupDO> groups) {
        this.groups = groups;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        groups.forEach(group -> sb.append(group.getId()).append(", "));
        return "{description='" + description + '\'' + ", groups=[" + sb.substring(0, sb.length() - 2) + "]}";
    }
}
