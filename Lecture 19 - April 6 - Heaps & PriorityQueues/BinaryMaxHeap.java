import java.util.ArrayList;

public class BinaryMaxHeap {

    // Fields
    private ArrayList<Integer> heap;

    // Constructor
    public BinaryMaxHeap() {
        this.heap = new ArrayList<>();
    }

    // Methods
    /**
     * Adds the given int (representing a priority) to the
     * proper spot in the heap
     *
     * @param toAdd Priority we desire to add
     */
    public void add(Integer toAdd) {
        // Step 1: Maintain a complete binary tree by adding
        // the new value at the bottom-most, right-most leaf
        // spot, or an append operation into the array
        this.heap.add(toAdd); // Appends toAdd to end

        // Step 2: Reheapify: bubble-up the value from its
        // current index into one where it is <= its parent
        bubbleUp(this.heap.size() - 1);
    }

    /**
     * Removes and returns the highest priority
     * item in the heap
     *
     * @return the removed item
     */
    public int poll() {
        int polledValue = this.heap.get(0);

        // Remove last value in list
        int lastValue = this.heap.remove(this.heap.size() - 1);
        // Assign last value to head
        if (!this.heap.isEmpty()) {
            this.heap.set(0, lastValue);
            this.trickleDown(0);
        }

        return polledValue;
    }

    private void trickleDown(int parentIndex) {
        int leftChildIndex = this.getChildIndex(parentIndex, false);
        int rightChildIndex = this.getChildIndex(parentIndex, true);

        int parent = this.heap.get(parentIndex);
        int leftChild = leftChildIndex < this.heap.size() ? this.heap.get(leftChildIndex) : -1;
        int rightChild = rightChildIndex < this.heap.size() ? this.heap.get(rightChildIndex) : -1;

        if (parent < leftChild && leftChild >= rightChild) {
            this.heap.set(parentIndex, leftChild);
            this.heap.set(leftChildIndex, parent);
            this.trickleDown(leftChildIndex);
        } else if (parent < rightChild) {
            this.heap.set(parentIndex, rightChild);
            this.heap.set(rightChildIndex, parent);
            this.trickleDown(rightChildIndex);
        }
    }

    private int getChildIndex(int parentIndex, boolean rightChild) {
        int result = (parentIndex * 2) + 1; // Index of left child
        if (rightChild) {
            result++;
        }
        return result;
    }

    private void bubbleUp(int index) {
        // Base Case: already at the root, nowhere
        // to go!
        if (index == 0) {
            return;
        }

        int parentIndex = getParentIndex(index);
        int parent = heap.get(parentIndex);
        int current = heap.get(index);

        // Check if parent is less than current, if so
        // swap and recurse!
        if (parent < current) {
            // list.set(indexToAssign, valueToAssign)
            // similar to arr[indexToAssign] = valueToAssign
            heap.set(index, parent);
            heap.set(parentIndex, current);
            // Recurse:
            bubbleUp(parentIndex);
        }
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2; // [!] Integer (floor) division
    }

    @Override
    public String toString() {
        return this.heap.toString();
    }

    public static void main(String[] args) {
        BinaryMaxHeap b = new BinaryMaxHeap();
        b.add(50);
        b.add(25);
        b.add(20);
        b.add(8);
        b.add(10);
        b.add(8);

        System.out.println("BEFORE POPPING 50");
        System.out.println(b);
        b.poll();
        System.out.println("AFTER POPPING 50");
        System.out.println(b);
    }

}
