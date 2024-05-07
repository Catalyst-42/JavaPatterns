package code.task23;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="COOKIES")
public class Cookie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "domain_name")
    private String domainName;

    @Override
    public String toString() {
        return "Cookie " + name;
    }
}
