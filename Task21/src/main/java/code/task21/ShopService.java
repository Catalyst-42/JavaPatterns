package code.task21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class ShopService {
    @Autowired
    private MailService mailer;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;

    public void findAllCarts() {
        log.info("Going to find all carts");
        mailer.sendEmail("findAllCarts", "Были найдены все тележки");
        System.out.println(
            "\033[32m" +
            "All carts: " +
            cartRepository.findAll() +
            "\033[0m"
        );
    }

    public void findAllItems() {
        log.info("Going to find all items");
        mailer.sendEmail("findAllItems", "Были найдены все предметы");
        System.out.println(
            "\033[32m" +
            "All items: " +
            itemRepository.findAll() +
            "\033[0m"
        );
    }

    public void findCartById(long id) {
        mailer.sendEmail("findAllItems", "Была найдена тележка с id = " + id);
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
        mailer.sendEmail("findAllItems", "Были найдены предметы для пользователя " + name);
        Cart cart = cartRepository.findByName(name).get(0);
        System.out.println(
            "\033[32m" +
            "Items of user with name " + cart.getName() + ": " +
            itemRepository.findByCart(cart) +
            "\033[0m"
        );
    }
}
