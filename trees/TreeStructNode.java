public class TreeStructNode {
    int data;
    TreeStructNode left;
    TreeStructNode right;

    TreeStructNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void addLeft(TreeStructNode left) {
        this.left = left;
    }

    public void addRight(TreeStructNode right) {
        this.right = right;
    }
}
