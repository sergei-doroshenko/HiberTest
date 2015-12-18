package acl.domain.badge;

import acl.domain.DomainObject;

import java.util.Date;

/**
 * Created by sergei on 12/17/15.
 */
public class ResourceBadgeData extends DomainObject {

    private Long badgeId;
    private Date date;

    public ResourceBadgeData() {
    }

    public Long getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(Long badgeId) {
        this.badgeId = badgeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ResourceBadgeData{" + super.toString() +
                ", badgeId=" + badgeId +
                ", date=" + date +
                '}';
    }
}
