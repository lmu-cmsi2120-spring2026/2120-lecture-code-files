public class BST {

    private BSTNode root;

    public BST() {
        this.root = null;
    }

    public void add(int toAdd) {
        // Case: empty tree
        if (this.root == null) {
            this.root = new BSTNode(toAdd);
            return;
        }

        // Case: not empty tree
        // Perform binary search to find
        // an empty child reference to
        // insert to
        BSTNode current = this.root;
        while (current != null) {
            // toAdd is less than current, move left
            if (toAdd < current.data) {
                if (current.left == null) {
                    current.left = new BSTNode(toAdd);
                    return;
                }
                current = current.left;
            }
            // toAdd is greater than current, move right
            if (toAdd > current.data) {
                if (current.right == null) {
                    current.right = new BSTNode(toAdd);
                    return;
                }
                current = current.right;
            }
        }

    }

    public boolean contains(int query) {
        BSTNode current = this.root;
        while (current != null) {
            if (query == current.data) {
                return true;
            }
            // TERNARY STATEMENT: CONDITIONAL ? VALUE IF TRUE : VALUE IF FALSE
            current = query < current.data ? current.left : current.right;
            // if (query < current.data) {
            // current = current.left;
            // } if (query > current.data) {
            // current = current.right;
            // }
        }
        return false;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.add(10);
        tree.add(2);
        tree.add(12);
        tree.add(4);
        tree.add(3);
        tree.add(11);
        System.out.println(tree.contains(10)); // true
        System.out.println(tree.contains(3));  // true
        System.out.println(tree.contains(14)); // false
        System.out.println(tree.contains(1));  // false
    }

    private class BSTNode {

        int data;
        BSTNode left, right;

        BSTNode(int data) {
            this.data = data;
        }
    }
}