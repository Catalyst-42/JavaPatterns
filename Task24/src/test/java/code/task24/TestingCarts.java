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
public class TestingCarts {
    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testFindAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        assertNotNull(carts);
    }

    @Test
    public void testFindCartById() {
        Long cartId = 1L;
        Cart cart = cartRepository.findById(cartId);
        assertNotNull(cart);
    }

    @Test
    public void testCartFourName() {
        Long cartId = 4L;
        Cart cart = cartRepository.findById(cartId);
        assertEquals(cart.getName(), "Aac");
    }
}
