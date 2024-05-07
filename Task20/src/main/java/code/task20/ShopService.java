package code.task20;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShopService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;

    public void findAllCarts() {
        log.info("Going to find all carts");
        System.out.println(
            "\033[32m" +
            "All carts: " +
            cartRepository.findAll() +
            "\033[0m"
        );
    }

    public void findAllItems() {
        log.info("Going to find all items");
        System.out.println(
            "\033[32m" +
            "All items: " +
            itemRepository.findAll() +
            "\033[0m"
        );
    }

    public void findCartById(long id) {
        log.info("Going to find cart with id == " + id);
        System.out.println(
            "\033[32m" +
            "Cart with id = 4: " +
            cartRepository.findById(id) +
            "\033[0m"
        );
    }
    
    public void findUserItems(String name) {
        log.info("Going to find " + name);
        Cart cart = cartRepository.findByName(name).get(0);
        System.out.println(
            "\033[32m" +
            "Items of user with name " + cart.getName() + ": " +
            itemRepository.findByCart(cart) +
            "\033[0m"
        );
    }
}
