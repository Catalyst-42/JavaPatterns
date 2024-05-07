package code.task24;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestingItems {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testFindAllItems() {
        List<Item> carts = itemRepository.findAll();
        assertNotNull(carts);
    }

    @Test
    public void testFindItemById() {
        Long itemId = 1L;
        Item cart = itemRepository.findById(itemId);
        assertNotNull(cart);
    }

    @Test
    public void testCartByDescription() {
        Item item = itemRepository.findByDescription("Union");
        assertEquals(item.getDescription(), "Union");
    }
}
