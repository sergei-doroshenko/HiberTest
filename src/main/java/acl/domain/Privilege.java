package acl.domain;

/**
 * Created by Sergei on 21.06.2015.
 */
public interface Privilege {
    Long getGroupId();

    void setGroupId(Long groupId);

    Long getPrivilegeId();

    void setPrivilegeId(Long privilegeId);
}
