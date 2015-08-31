package acl.domain;

import java.util.List;
import java.util.Set;

/**
 * Created by Sergei on 22.06.2015.
 */
public class GroupDO extends DomainObject {
    private Long parentId;
    private Set<PrivilegeDO> privileges;
    private List<String> resourcesIds;

    public GroupDO() {
    }

    public GroupDO(Long id, String name, Long parentId, Set<PrivilegeDO> privileges, List<String> resourcesIds) {
        super(id, name);
        this.parentId = parentId;
        this.privileges = privileges;
        this.resourcesIds = resourcesIds;
    }

    public Set<PrivilegeDO> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<PrivilegeDO> privileges) {
        this.privileges = privileges;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<String> getResourcesIds() {
        return resourcesIds;
    }

    public void setResourcesIds(List<String> resourcesIds) {
        this.resourcesIds = resourcesIds;
    }

    @Override
    public String toString() {
        return "GroupDO{" + super.toString() +
                ", parentId=" + parentId +
                ", privileges=" + privileges +
                ", resourcesIds=" + resourcesIds +
                '}';
    }
}
