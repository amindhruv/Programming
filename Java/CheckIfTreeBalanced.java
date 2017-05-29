public class CheckIfTreeBalanced {
    public static void main(String[] args) {
        CreateBST.Node root = new CreateBST.Node(5);
        root.left = new CreateBST.Node(3);
        root.right = new CreateBST.Node(10);
        root.left.left = new CreateBST.Node(1);
        root.left.right = new CreateBST.Node(4);
        root.right.right = new CreateBST.Node(11);
        System.out.println(isBalanced(root) ? "Balanced" : "Unbalanced");
    }

    private static boolean isBalanced(CreateBST.Node root) {
        return (maxHeight(root) - minHeight(root)) < 2;
    }

    private static int minHeight(CreateBST.Node root) {
        if (root == null) return 0;
        return Math.min(minHeight(root.left), minHeight(root.right)) + 1;
    }

    private static int maxHeight(CreateBST.Node root) {
        if (root == null) return 0;
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }
}