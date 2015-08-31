package acl.domain.resource;

import java.util.Collection;

/**
 * Created by Sergei on 16.07.2015.
 */
public class Resource {
    private Long id;
    private String firstName;
    private String lastName;
    private Double baseCost;
    private Long currencyId;
    private transient Collection<Skill> skills;

    public Resource() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(Double baseCost) {
        this.baseCost = baseCost;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Collection<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Collection<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Resource{" + id + ", " + firstName + " " + lastName +
                ", skills:" + skills +
                '}';
    }
}
