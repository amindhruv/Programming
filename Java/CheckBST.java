public class CheckBST {
    public static void main(String[] args) {
        CreateBST.Node root = new CreateBST.Node(7);
        root.left = new CreateBST.Node(4);
        root.right = new CreateBST.Node(9);
        root.left.left = new CreateBST.Node(1);
        root.left.right = new CreateBST.Node(6);
        System.out.println(checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? "It's BST!" : "It's not BST.");
    }

    private static boolean checkBST(CreateBST.Node root, int min, int max) {
        return root == null || (root.data > min && root.data < max && checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max));
    }
}