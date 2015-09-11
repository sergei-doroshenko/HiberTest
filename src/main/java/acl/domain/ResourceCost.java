package acl.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Sergei on 11.09.2015.
 */
public class ResourceCost extends DomainObject {
    private static final long serialVersionUID = 4027728489009256039L;

    private Date startDate;
    private Long resourceId;
    private BigDecimal baseCost;
    private CurrencyDO currency;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public BigDecimal getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(BigDecimal baseCost) {
        this.baseCost = baseCost;
    }

    public CurrencyDO getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyDO currency) {
        this.currency = currency;
    }
}
