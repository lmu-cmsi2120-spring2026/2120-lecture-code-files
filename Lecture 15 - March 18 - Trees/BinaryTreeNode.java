public class BinaryTreeNode {

    int data;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public static void preOrderPrint (BinaryTreeNode n) {
        if (n == null) {return;}
        System.out.println(n.data);
        preOrderPrint(n.left);
        preOrderPrint(n.right);
    }

    public static void postOrderPrint (BinaryTreeNode n) {
        if (n == null) {return;}
        postOrderPrint(n.left);
        postOrderPrint(n.right);
        System.out.println(n.data);
        }

    public static void inOrderPrint (BinaryTreeNode n) {
        if (n == null) {return;}
        inOrderPrint(n.left);
        System.out.println(n.data);
        inOrderPrint(n.right);
    }

    /**
     * Reverses the order of all subtrees rooted at the calling node
     * For example:
     *     5 <- root            root -> 5
     *    / \                          / \
     *   6   9  root.invertTree():    9   6
     *  / \                              / \
     * 4   7                            7   4
     */
    public void invertTree () {
        throw new UnsupportedOperationException();
    }


    /**
     * Returns whether or not the given Binary Tree rooted at the
     * calling node would be considered a BinarySearchTree (i.e.,
     * have only values in the left subtree that are less than it
     * and only values in the right subtree that are greater for
     * all subtrees).
     * For example:
     *   root-> 5
     *         / \
     *        6   9
     *       / \   \
     *      4   7   9
     *
     * root.isBinarySearchTree() => False
     * root.left.isBinarySearchTree() => True
     * root.right.isBinarySearchTree() => False
       root.right.right.isBinarySearchTree() => True
     */
    public boolean isBinarySearchTree () {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sum of all even-numbered nodes rooted at the
     * calling node, including the calling node's if its data is
     * even.
     * For example:
     *   root-> 5
     *         / \
     *        6   9
     *       / \   \
     *      4   7   8
     *
     * root.sumEven() => 18
     * root.left.sumEven() => 10
     * root.right.sumEven() => 8
     */
    public int sumEven () {
        throw new UnsupportedOperationException();
    }

    public static void main (String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(2);
        BinaryTreeNode it = root.left;
        it.left = new BinaryTreeNode(1);
        it.right = new BinaryTreeNode(0);
        it = root.right;
        it.left = new BinaryTreeNode(8);

        System.out.println("Pre-Order Traversal:");
        preOrderPrint(root);
        System.out.println("Post-Order Traversal:");
        postOrderPrint(root);
        System.out.println("In-Order Traversal:");
        inOrderPrint(root);
    }

}
