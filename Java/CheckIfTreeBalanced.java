public class CheckIfTreeBalanced {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(11);
        System.out.println(isBalanced(root) ? "Balanced" : "Unbalanced");
    }

    private static boolean isBalanced(TreeNode root) {
        return (maxHeight(root) - minHeight(root)) < 2;
    }

    private static int minHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.min(minHeight(root.left), minHeight(root.right)) + 1;
    }

    private static int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }
    
    /*class TreeNode {
        int value;
        TreeNode left, right;
        TreeNode(int value) { this.value = value; }
    }*/
}
