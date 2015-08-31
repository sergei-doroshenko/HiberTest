package acl.domain;

/**
 * Created by Sergei on 22.06.2015.
 */
public class DomainObject {
    private Long id;
    private String name;

    public DomainObject() {
    }

    public DomainObject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name;
    }
}
