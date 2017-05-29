public class InOrderSuccessor {
    public static void main(String[] args) {
        CreateBST.Node root = new CreateBST.Node(15);
        root.left = new CreateBST.Node(10);
        root.right = new CreateBST.Node(20);
        root.left.left = new CreateBST.Node(8);
        root.left.right = new CreateBST.Node(12);
        root.left.left.left = new CreateBST.Node(6);
        root.left.right.left = new CreateBST.Node(11);
        root.right.left = new CreateBST.Node(17);
        root.right.right = new CreateBST.Node(25);
        root.right.left.left = new CreateBST.Node(16);
        root.right.right.right = new CreateBST.Node(27);
        CreateBST.Node successor = inOrderSuccessor(root, 10);  //Case 1: if node has right child
        System.out.println(successor == null ? "No successor found!" : successor.data);
        successor = inOrderSuccessor(root, 8);  //Case 2 : if node doesn't have right child & going up from left
        System.out.println(successor == null ? "No successor found!" : successor.data);
        successor = inOrderSuccessor(root, 12); //Case 3 : if node doesn't have right child & going up from right
        System.out.println(successor == null ? "No successor found!" : successor.data);
        //Checking edge cases
        successor = inOrderSuccessor(root, 27); //successor of maximum element
        System.out.println(successor == null ? "No successor found!" : successor.data);
        successor = inOrderSuccessor(root, 6);  //successor of minimum element
        System.out.println(successor == null ? "No successor found!" : successor.data);
        successor = inOrderSuccessor(root, 15); //successor of root
        System.out.println(successor == null ? "No successor found!" : successor.data);
    }

    private static CreateBST.Node inOrderSuccessor(CreateBST.Node root, int data) { //O(lg n)
        CreateBST.Node current = find(root, data);
        if (current == null) return null;
        if (current.right != null) return findMin(current.right);
        CreateBST.Node successor = null;
        CreateBST.Node ancestor = root;
        while (ancestor != current) {
            if (current.data < ancestor.data) {
                successor = ancestor;
                ancestor = ancestor.left;
            } else ancestor = ancestor.right;
        }
        return successor;
    }

    private static CreateBST.Node findMin(CreateBST.Node root) {    //O(lg n)
        while (root.left != null) root = root.left;
        return root;
    }

    private static CreateBST.Node find(CreateBST.Node root, int data) { //O(lg n)
        if (root == null) return null;
        if (data == root.data) return root;
        else if (data < root.data) return find(root.left, data);
        else return find(root.right, data);
    }
}