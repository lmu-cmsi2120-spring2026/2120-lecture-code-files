import java.util.ArrayList;

public class BinaryTreeNode {

    int data;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public ArrayList<Integer> getLeaves () {
        ArrayList<Integer> result = new ArrayList<>();
        getLeaves(this, result);
        return result;
    }

    /**
    * Recursively performs a preorder traversal on the given Binary Tree to create a
    * List of all leaf values stored within.
    */
    private void getLeaves(BinaryTreeNode n, ArrayList<Integer> result) {
        // Base case:
        if (n == null) { return; }
        // Visit behavior: check to see if we're at a leaf, and add it if so
        if (n.left == null && n.right == null) {
            result.add(n.data);

        // Recursive case: not at a leaf, so keep looking deeper
        } else {
            getLeaves(n.left, result);
            getLeaves(n.right, result);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(2);
        BinaryTreeNode it = root.left;
        it.left = new BinaryTreeNode(1);
        it.right = new BinaryTreeNode(0);
        it = root.right;
        it.left = new BinaryTreeNode(8);

        System.out.println(root.getLeaves());
    }

}
