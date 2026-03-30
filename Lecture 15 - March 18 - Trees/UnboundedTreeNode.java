import java.util.ArrayList;

public class UnboundedTreeNode {

    // Fields
    private int data;
    private ArrayList<UnboundedTreeNode> children;

    // Constructor
    public UnboundedTreeNode(int data) {
        this.data = data;
        this.children = new ArrayList<UnboundedTreeNode>();
    }

    // Methods
    public void add(int toAdd) {
        this.children.add(new UnboundedTreeNode(toAdd));
    }

    public UnboundedTreeNode getChild(int index) {
        return children.get(index);
    }

    public int getInt() {
        return this.data;
    }

    public static void main(String[] args) {
        UnboundedTreeNode root = new UnboundedTreeNode(5);
        root.add(4);
        root.add(2);
        root.add(1);
        UnboundedTreeNode it = root.getChild(1);
        it.add(2);
        it.add(3);
    }

}
