package code.task24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;
    
    public void run() {
        System.out.println(
            "\033[32m" +
            "All carts: " +
            cartRepository.findAll() +
            "\033[0m"
        );

        System.out.println(
            "\033[32m" +
            "All items: " +
            itemRepository.findAll() +
            "\033[0m"
        );
        
        System.out.println(
            "\033[32m" +
            "Cart with id = 4: " +
            cartRepository.findById(4) +
            "\033[0m"
        );

        Cart cart = cartRepository.findByName("UserTwo").get(0);
        System.out.println(
            "\033[32m" +
            "Items of user with name " + cart.getName() + ": " +
            itemRepository.findByCart(cart) +
            "\033[0m"
        );
    }
}
