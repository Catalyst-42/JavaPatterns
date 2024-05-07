package code.task17;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="ITEMS")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;

    @Column(name = "desctiption")
    private String description;

    @Override
    public String toString() {
        return "\n\t<Item id=" + id + ", description=" + description + ">";
    }
}
