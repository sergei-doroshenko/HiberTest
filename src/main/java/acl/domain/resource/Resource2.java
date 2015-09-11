package acl.domain.resource;

import acl.domain.CurrencyDO;
import acl.domain.DomainObject;

import java.util.List;

/**
 * Created by Sergei on 11.09.2015.
 */
public class Resource2 extends DomainObject {

    public static final String ENTITY_RESOURCE_FULL = "Resource_Full";
    public static final String ENTITY_RESOURCE_SHORT = "Resource_Short";
    public static final String ENTITY_RESOURCE_SHORT2 = "Resource_Short2";

    private String login;

    private String firstName;

    private String lastName;

    private String nativeName;

    private List<Skill> skills;

    private Boolean active;

    private Boolean nwoProhibited;

    private Boolean sex;

    private String email;

    private Boolean notifyUnfilledTs = Boolean.TRUE;

    private CurrencyDO empCurrency;

    public Resource2() {
        super();
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns Resource's first name.
     *
     * @return the firstName of the Resource.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets Resource's first name.
     *
     * @param firstName the first name of the Resource.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns Resource's last name.
     *
     * @return the lastName of the Resource.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets Resource's last name.
     *
     * @param lastName the last name of the Resource.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns Resource's russian name.
     *
     * @return the nativeName of the Resource.
     */
    public String getNativeName() {
        return nativeName;
    }

    /**
     * Sets Resource's ussian name.
     *
     * @param nativeName the russian name of the Resource.
     */
    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    /**
     * Returns Resource's skills.
     *
     * @return skills of the Resource.
     */
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * Sets Resource's skills.
     *
     * @param skills skills of the Resource.
     */
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return the sex
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getNotifyUnfilledTs() {
        return notifyUnfilledTs;
    }

    public void setNotifyUnfilledTs(Boolean notifyUnfilledTs) {
        this.notifyUnfilledTs = notifyUnfilledTs;
    }

    public CurrencyDO getEmpCurrency() {
        return empCurrency;
    }

    public void setEmpCurrency(CurrencyDO empCurrency) {
        this.empCurrency = empCurrency;
    }

    public Boolean getNWOProhibited() {
        return nwoProhibited;
    }

    public void setNWOProhibited(Boolean nwoProhibited) {
        this.nwoProhibited = nwoProhibited;
    }

    @Override
    public String getName() {
        return (getLastName() + ' ' + getFirstName());
    }

    @Override
    public String toString() {
        return "Resource2{id=" + getId() + ", name=" + getName() + "}";
    }
}
