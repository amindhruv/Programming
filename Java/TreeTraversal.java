public class TreeTraversal {
    public static void main(String[] args) {
        CreateBST.Node root = new CreateBST.Node(5);
        root.left = new CreateBST.Node(1);
        root.right = new CreateBST.Node(9);
        root.left.left = new CreateBST.Node(0);
        root.left.right = new CreateBST.Node(4);
        root.right.left = new CreateBST.Node(7);
        root.right.right = new CreateBST.Node(3);
        System.out.println("In order traversal:");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("Pre order traversal:");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("Post order traversal:");
        postOrderTraversal(root);
    }

    private static void inOrderTraversal(CreateBST.Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private static void preOrderTraversal(CreateBST.Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void postOrderTraversal(CreateBST.Node root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
}