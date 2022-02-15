import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {
    public void inorder(TreeStructNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left);
        }
        System.out.print(root.data + " -> ");
        if (root.right != null) {
            inorder(root.right);
        }
    }

    public void preorder(TreeStructNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " -> ");
        if (root.left != null) {
            preorder(root.left);
        }

        if (root.right != null) {
            preorder(root.right);
        }
    }

    public void postorder(TreeStructNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            postorder(root.left);
        }

        if (root.right != null) {
            postorder(root.right);
        }
        System.out.print(root.data + " -> ");
    }

    public void bfs(TreeStructNode root, int v) {
        // data 1 indexed
        boolean visited[] = new boolean[v + 1];
        visited[0] = true;
        Queue<TreeStructNode> q = new LinkedList<>();
        visited[root.data] = true;
        q.add(root);
        while (!q.isEmpty()) {
            TreeStructNode currNode = q.remove();
            System.out.print(currNode.data + " -> ");
            if (currNode.left != null && !visited[currNode.left.data]) {
                visited[currNode.left.data] = true;
                q.add(currNode.left);
            }
            if (currNode.right != null && !visited[currNode.right.data]) {
                visited[currNode.right.data] = true;
                q.add(currNode.right);
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;
        TreeStructNode nodes[] = new TreeStructNode[V];
        for (int i = 0; i < V; i++) {
            nodes[i] = new TreeStructNode(i + 1);
        }
        // root is nodes[0]
        nodes[1].addLeft(nodes[3]);
        nodes[1].addRight(nodes[4]);
        nodes[0].addLeft(nodes[1]);
        nodes[0].addRight(nodes[2]);
        TreeTraversals traversals = new TreeTraversals();
        traversals.inorder(nodes[0]);
        System.out.println();
        traversals.preorder(nodes[0]);
        System.out.println();
        traversals.postorder(nodes[0]);
        System.out.println();
        traversals.bfs(nodes[0], V);
        System.out.println();

    }
}
