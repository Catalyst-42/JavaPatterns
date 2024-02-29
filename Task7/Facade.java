package Task7;

import java.util.ArrayList;
import java.util.List;

public class Facade {
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    public void performOperation() {
        for (Component component : components) {
            component.operation();
        }
    }
}
