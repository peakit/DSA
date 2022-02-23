
// Leetcode problem no. 617

public class MergeTwoBin {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return this.val + " left: " + this.left + " right: " + this.right;
        }
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode newRootNode = new TreeNode(0);

        if (root1 != null) {
            newRootNode.val += root1.val;
        }
        if (root2 != null) {
            newRootNode.val += root2.val;
        }
        TreeNode left1 = null;
        TreeNode right1 = null;
        if (root1 != null) {
            left1 = root1.left;
            right1 = root1.right;
        }

        TreeNode left2 = null;
        TreeNode right2 = null;
        if (root2 != null) {
            left2 = root2.left;
            right2 = root2.right;
        }
        newRootNode.left = mergeTrees(left1, left2);
        newRootNode.right = mergeTrees(right1, right2);

        return newRootNode;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(0);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);

        root1.left = left1;
        root1.right = right1;

        TreeNode root2 = new TreeNode(1);
        root2.left = null;
        root2.right = null;

        TreeNode finalRoot = mergeTrees(root1, root2);
        System.out.println(finalRoot);
    }
}