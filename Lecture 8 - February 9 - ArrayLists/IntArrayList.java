public class IntArrayList implements IntList {

    private static final int START_SIZE = 8;

    private int size;
    private int[] items;

    public IntArrayList () {
        this.size = 0;
        this.items = new int[START_SIZE];
    }

    public void append (int toAdd) {
        checkAndGrow();
        this.items[this.size] = toAdd;
        this.size++;
    }

    public int getAt (int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Requested index out of range");
        }
        return this.items[index];
    }

    public void removeAt (int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Requested index out of range");
        }
        shiftLeft(index);
        this.size--;
    }

    public void prepend (int toAdd) {
        insertAt(toAdd, 0);
    }

    public void insertAt (int toAdd, int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Requested index out of range");
        }
        checkAndGrow();
        shiftRight(index);
        this.items[index] = toAdd;
        this.size++;
    }

    @Override
    public String toString () {
        String[] result = new String[this.size];
        for (int i = 0; i < this.size; i++) {
            result[i] = "" + this.items[i];
        }
        return "[" + String.join(", ", result) + "]";
    }

    private void shiftRight (int index) {
        for (int i = size; i > index; i--) {
            this.items[i] = this.items[i-1];
        }
    }

    private void shiftLeft (int index) {
        for (int i = index; i < this.size-1; i++) {
            this.items[i] = this.items[i+1];
        }
    }

    private void checkAndGrow () {
        if (this.size < this.items.length) {
            return;
        }

        int[] newItems = new int[this.items.length * 2];

        for (int i = 0; i < this.items.length; i++) {
            newItems[i] = this.items[i];
        }

        this.items = newItems;
    }

}