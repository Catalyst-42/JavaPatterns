package code.task22;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="CART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;
    
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="cart")
    private Set<Item> items;

    @Override
    public String toString() {
        return "'cart': " + "{\n\t'id': " + id + ",\n\t'name': '" + name + "'\n}";
    }
}
