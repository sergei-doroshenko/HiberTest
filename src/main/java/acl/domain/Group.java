package acl.domain;

import java.util.List;

/**
 * Created by Sergei on 21.06.2015.
 */
public interface Group {
    Long getId();

    void setId(Long id);

    String getGroupName();

    void setGroupName(String groupName);

    List<Long> getResourceIds();

    void setResourceIds(List<Long> resourceIds);

    List<Long> getPrivilegeIds();

    void setPrivilegeIds(List<Long> privilegeIds);
}
