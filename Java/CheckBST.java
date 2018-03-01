public class CheckBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        System.out.println(checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? "It's BST!" : "It's not BST.");
    }

    private static boolean checkBST(TreeNode root, int min, int max) {
        return root == null || (root.data > min && root.data < max && checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max));
    }
    
    /*class TreeNode {
        int data;
        TreeNode left, right;
    }*/
}
