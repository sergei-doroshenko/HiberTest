package acl.domain.badge;
import acl.domain.DomainObject;

/**
 * Created by sergei on 12/17/15.
 */
public class Badge extends DomainObject {
    private Short effectivePeriod;

    public Badge() {
    }

    public Short getEffectivePeriod() {
        return effectivePeriod;
    }

    public void setEffectivePeriod(Short effectivePeriod) {
        this.effectivePeriod = effectivePeriod;
    }

    @Override
    public String toString() {
        return "Badge{" + super.toString() +
                ", effectivePeriod=" + effectivePeriod + '}';
    }
}
