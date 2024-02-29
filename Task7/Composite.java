package Task7;

import java.util.ArrayList;
import java.util.List;

class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    @Override
    public void operation() {
        System.out.println("Doing composite operation");
        
        for (Component child: children) {
            child.operation();
        }
    }

    @Override
    public void add(Composite c) {
        children.add(c);
    }

    @Override
    public void remove(Composite c) {
        children.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return children.get(i);
    }
}