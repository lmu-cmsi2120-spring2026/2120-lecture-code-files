public class ConstructedIntStack {

    private final IntLinkedList list;

    ConstructedIntStack() {
        this.list = new IntLinkedList();
    }

    public void push(int toPush) {
        this.list.prepend(toPush);
    }

    public int pop() {
        int toReturn = peek();
        this.list.removeAt(0);
        return toReturn;
    }

    public int peek() {
        return this.list.getAt(0);
    }
}
