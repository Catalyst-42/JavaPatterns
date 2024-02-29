package Task7;

class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf operation");
    }

    @Override
    public void add(Composite c) {}

    @Override
    public void remove(Composite c) {}

    @Override
    public Component getChild(int i) {
        return null;
    }
}
