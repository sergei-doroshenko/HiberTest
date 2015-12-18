package acl.domain.badge;

import acl.domain.DomainObject;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by sergei on 12/17/15.
 */
public class ResourceBadge extends DomainObject {

    private Badge badge;
    private Date date;

    public ResourceBadge() {
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ResourceBadge{" + super.toString() +
                ", badge=" + badge + ", date=" + date + '}';
    }
}
