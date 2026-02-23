public class IntStack extends IntLinkedList implements TrueIntStack {

    IntStack() {
        super();
    }

    public void push(int toPush) {
        super.prepend(toPush);
    }

    public int pop() {
        int toReturn = peek();
        super.removeAt(0);
        return toReturn;
    }

    public int peek() {
        return super.getAt(0);
    }

    @Override
    public void append(int toAdd) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        IntStack stacky = new IntStack();
        stacky.push(1);
        stacky.push(2);
        stacky.push(3);
        stacky.removeAt(1);
        // [?] What gets printed here?
        System.out.println(stacky.peek());

        TrueIntStack trueStacky = new IntStack();
        trueStacky.push(1);
        trueStacky.push(2);
        trueStacky.push(3);

        // Uncomment this - notice that it errors!
        // trueStacky.removeAt(1);

        System.out.println(trueStacky.peek());
    }

}
