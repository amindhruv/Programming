public class BSTInsertDelete {
    public static void main(String[] args) {
        CreateBST.Node root = insert(null, 5);
        root = insert(root, 10);
        root = insert(root, 3);
        root = insert(root, 4);
        root = insert(root, 1);
        root = insert(root, 11);
        inOrderPrint(root);
        System.out.println();
        root = delete(root, 5);
        inOrderPrint(root);
        System.out.println();
    }

    private static CreateBST.Node delete(CreateBST.Node root, int value) {
        if (root == null) return null;
        else if (value < root.data) root.left = delete(root.left, value);
        else if (value > root.data) root.right = delete(root.right, value);
        else {
            if (root.left == null && root.right == null) root = null;
            else if (root.left == null) root = root.right;
            else if (root.right == null) root = root.left;
            else {
                CreateBST.Node temp = findMin(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        return root;
    }

    private static CreateBST.Node findMin(CreateBST.Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    private static void inOrderPrint(CreateBST.Node root) {
        if (root == null) return;
        inOrderPrint(root.left);
        System.out.print(root.data + " ");
        inOrderPrint(root.right);
    }

    private static CreateBST.Node insert(CreateBST.Node root, int value) {
        if (root == null) root = new CreateBST.Node(value);
        else if (value < root.data) root.left = insert(root.left, value);
        else root.right = insert(root.right, value);
        return root;
    }
}