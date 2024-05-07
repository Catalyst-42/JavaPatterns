package code.task20;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findById(long id);
    List<Item> findByCart(Cart cart);
    Item findByDescription(String description);
}
