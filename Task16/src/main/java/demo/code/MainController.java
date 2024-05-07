package demo.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private CartRepositry cartRepository;
    @GetMapping("/getitems/{id}")
    public @ResponseBody String getDogs(@PathVariable("id") int id) {
        Cart cart = cartRepository.findById(id).get();
        return "Cart " + cart.getName() + " owns: " + cart.getItems().toString();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Cart> getAllUsers() {
        return cartRepository.findAll();
    }
}
