import java.util.ArrayList;
import java.util.List;

// Leetcode problem no. 116
public class PopulateNextPointerInTree {
    private static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.val + " ";
        }
    }

    public static Node connect(Node root) {
        List<Node> levelTraversal = findLevelTraversal(root);
        
        0
        2^0 - < 2^1
        2^1 - < 2^2
        2^2 - < 2^3
        System.out.println("Level order traversal is: " + levelTraversal);

        return root;
    }

    private static List<Node> findLevelTraversal(Node root) {
        List<Node> levelTraversal = new ArrayList<>();

        if (root != null) {
            levelTraversal.add(root);

            for (int i = 0; i < levelTraversal.size(); i++) {
                Node aNode = levelTraversal.get(i);
                if (aNode.left != null && aNode.right != null) {
                    levelTraversal.add(aNode.left);
                    levelTraversal.add(aNode.right);

                    // aNode.left.next = aNode.right;
                }
            }
        }
        return levelTraversal;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        root.left = left1;
        root.right = right1;

        Node left2 = new Node(4);
        Node right2 = new Node(5);
        left1.left = left2;
        left1.right = right2;

        Node left3 = new Node(6);
        Node right3 = new Node(7);
        right1.left = left3;
        right1.right = right3;

        connect(root);
    }
}
