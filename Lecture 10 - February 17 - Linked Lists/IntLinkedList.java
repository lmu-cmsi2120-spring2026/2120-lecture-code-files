/**
 * An implementation of the IntList interface using a singly linked list.
 * Elements are stored in Node objects that are chained together via
 * references, rather than in a contiguous array.
 */
public class IntLinkedList implements IntList {

    // Fields:
    // head: reference to the first Node in the list (null if empty)
    // size: tracks the number of elements currently in the list
    private Node head;
    private int size;

    /**
     * Constructs an empty IntLinkedList.
     */
    public IntLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Returns the number of elements currently in the list.
     *
     * @return the size of the list
     */
    public int size() {
        return this.size;
    }

    /**
     * Adds the given int to the end of the list.
     *
     * @param toAdd the int to append
     */
    public void append(int toAdd) {
        // Step 1: Create a new Node with the desired data
        Node toAppend = new Node(toAdd);
        this.size++;
        // Case 1: List is currently Empty
        if (this.head == null) {
            this.head = toAppend;
            return;
        }
        // Case 2: List is not empty
        // Step 2: Navigate to where in the list to insert
        // the node
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        // At this point, current is now the last node in the list
        // Step 3: Modify references to make the Node part of the list
        current.next = toAppend;
    }

    /**
     * Adds the given int to the beginning of the list.
     *
     * @param toAdd the int to prepend
     */
    public void prepend(int toAdd) {
        // Step 1: Create a new Node with the desired data
        Node toPrepend = new Node(toAdd);
        // Step 2: Point the new node's next to the current head
        // (this works even if head is null -- the new node just has no next)
        toPrepend.next = this.head;
        // Step 3: Update head to be the new node
        this.head = toPrepend;
        this.size++;
    }

    /**
     * Returns the int stored at the given index in the list.
     *
     * @param index the index of the element to return
     * @return the int at the specified index
     * @throws IllegalArgumentException if index is out of bounds
     */
    public int getAt(int index) {
        if (index >= this.size || index < 0) {
            throw new IllegalArgumentException("index out of legal range");
        }

        // Walk forward through the list, counting down the index
        Node current = this.head;
        while (index > 0) {
            current = current.next;
            index--;
        }
        // At this point, current is now the node at the desired index
        return current.data;
    }

    /**
     * Inserts the given int at the given index
     *
     * @param toAdd the int to insert
     * @param index the index at which to insert
     * @throws IllegalArgumentException if index is out of bounds
     */
    public void insertAt(int toAdd, int index) {
        // Hmm... looks like this one hasn't been implemented yet.
        // Perhaps some good practice to prep for the Midterm?
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the element at the specified index from the list
     *
     * @param index the index of the element to remove
     * @throws IllegalArgumentException if index is out of bounds
     */
    public void removeAt(int index) {
        if (index >= this.size || index < 0) {
            throw new IllegalArgumentException("index out of legal range");
        }

        // We track two references:
        // - current: the node we want to remove
        // - prev: the node right before it (null if removing the head)
        Node current = this.head;
        Node prev = null;

        // Walk forward to the target index
        while (index > 0 && current != null) {
            prev = current;
            current = current.next;
            index--;
        }

        // Case 1: Removing the head node
        // prev is null, so we just advance head past the removed node
        if (current == this.head) {
            this.head = current.next;
        }
        // Case 2: Removing a node in the middle or at the end
        // We "unlink" current by pointing prev's next past it
        if (prev != null) {
            prev.next = current.next;
        }
        this.size--;
    }

    /**
     * Returns a new Iterator positioned at the head of this list.
     *
     * @return an Iterator over this IntLinkedList
     */
    public Iterator getIterator() {
        return new Iterator(this);
    }

    // Inner Classes: classes defined within other
    // classes. Outside of the class, must be accessed
    // as EnclosingClass.InnerClass

    /**
     * A single element in the linked list. Each Node holds one int
     * and a reference to the next Node in the chain.
     */
    private class Node {

        int data;
        Node next;

        /**
         * Constructs a Node with the given data and no next reference.
         *
         * @param data the int value to store
         */
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * An iterator over an IntLinkedList that allows traversal one
     * element at a time. Intended usage:
     * IntLinkedList.Iterator it = list.getIterator();
     * while (it.hasNext()) {
     * System.out.println(it.getCurrentInt());
     * it.next();
     * }
     */
    public class Iterator {

        // The node the iterator is currently pointing at
        private Node current;

        // [!] Note: we'll make this a private constructor because we want users
        // to get Iterators through our IntLinkedList's getIterator method
        /**
         * Constructs an Iterator starting at the head of the given list.
         * Private so that callers must use IntLinkedList.getIterator()
         *
         * @param host the IntLinkedList to iterate over
         */
        private Iterator(IntLinkedList host) {
            this.current = host.head;
        }

        /**
         * Returns true if the iterator has a current element to read.
         * (i.e., the iterator has not been advanced past the end of the list)
         *
         * @return true if there is a current element, false otherwise
         */
        public boolean hasNext() {
            return this.current != null;
        }

        /**
         * Advances the iterator to the next element in the list.
         * If the iterator is already past the end, this does nothing.
         */
        public void next() {
            if (this.current == null) {
                return;
            }
            this.current = this.current.next;
        }

        /**
         * Returns the int value at the iterator's current position.
         *
         * @return the current element's data
         * @throws IllegalStateException if there is no current element
         */
        public int getCurrentInt() {
            if (this.current == null) {
                throw new IllegalStateException("No current element");
            }
            return this.current.data;
        }

    }

}
