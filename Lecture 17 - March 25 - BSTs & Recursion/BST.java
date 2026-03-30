import java.util.ArrayList;

public class BST {

    private BSTNode root;

    public BST() {
        this.root = null;
    }

    public void add(int toAdd) {
        if (this.root == null) {
            this.root = new BSTNode(toAdd);
            return;
        }

        BSTNode current = this.root;
        while (current != null) {
            if (toAdd < current.data) {
                if (current.left == null) {
                    current.left = new BSTNode(toAdd);
                    return;
                }
                current = current.left;
            }
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

            // The above is the logical equivalent of:
            // if (query < current.data) {
            // current = current.left;
            // } if (query > current.data) {
            // current = current.right;
            // }
        }
        return false;
    }

    public void addRec (int toAdd) {
        // Set the root equal to the result of the helper
        this.root = this.addRec(this.root, toAdd);
    }

    private BSTNode addRec (BSTNode n, int toAdd) {
        // ...which will either be a new node in the case of an empty tree,
        // or where we've found the insertion spot to be
        if (n == null) {
            return new BSTNode(toAdd);
        }
        // ...and can set the left and right references appropriately depending
        // on where the node should go
        if (toAdd < n.data) {
            // [!] Update balance factor here since it'd go in left subtree
            n.left = addRec(n.left, toAdd);
        } else {
            // [!] Update balance factor here since it'd go in right subtree
            n.right = addRec(n.right, toAdd);
        }
        // Finally, returning n as the current occupant of the parent's reference
        return n;
    }

    public boolean containsRec(int query) {
        // Call a recursive helper to decide if the
        // query is in our tree and return its result
        return containsRec(this.root, query);
    }

    private boolean containsRec(BSTNode current, int query) {
        // If we get passed a null BSTNode, it means
        // the query would have been in this subtree
        // if it existed, which means it doesn't exist!
        if (current == null) {
            return false;
        }
        // If we find the query, we can return true
        if (current.data == query) {
            return true;
        }
        // Otherwise, check if the current node is
        // less or greater than our query, and recurse
        // left or right depending on the answer to
        // that question
        if (query < current.data) {
            return containsRec(current.left, query);
        }
        return containsRec(current.right, query);
    }

    public ArrayList<Integer> getSortedList() {
        // Create an ArrayList that we'll return later
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Pass in the ArrayList to a recursive private helper method,
        // along with the root.
        // [!] Remember that Objects pass a copy of their *reference* in
        // Java, so buildSortedList will modify the list it's passed in,
        // but doesn't need to return it, as we're still holding onto a
        // reference to the same object in this method!
        buildSortedList(this.root, result);
        // Finally, return the list of sorted values.
        return result;
    }

    private void buildSortedList(BSTNode current, ArrayList<Integer> result) {
        // If we've been passed a null BSTNode, there's nothing
        // to do here, so we just return!
        if (current == null) {
            return;
        }
        // First, recurse on this Node's left subtree
        buildSortedList(current.left, result);
        // Once the left subtree's nodes have been added
        // to the list, append this Node to the list.
        result.add(current.data);
        // Finally, recurse on this Node's right subtree
        buildSortedList(current.right, result);
    }

    private class BSTNode {

        int data;
        BSTNode left, right;

        BSTNode(int data) {
            this.data = data;
        }
    }
}