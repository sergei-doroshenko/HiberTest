package acl.dao;

/**
 * Created by sergei on 12/17/15.
 */
public class ResBadgeDataShort {
    private Long id;
    private Long badgeId;

    public ResBadgeDataShort() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(Long badgeId) {
        this.badgeId = badgeId;
    }

    @Override
    public String toString() {
        return "ResBadgeDataShort{" +
                "id=" + id +
                ", badgeId=" + badgeId +
                '}';
    }
}
