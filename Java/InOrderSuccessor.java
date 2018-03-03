public class InOrderSuccessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.left.left.left = new TreeNode(6);
        root.left.right.left = new TreeNode(11);
        root.right.left = new TreeNode(17);
        root.right.right = new TreeNode(25);
        root.right.left.left = new TreeNode(16);
        root.right.right.right = new TreeNode(27);
        TreeNode successor = inOrderSuccessor(root, 10);  //Case 1: if node has right child
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

    private static TreeNode inOrderSuccessor(TreeNode root, int data) { //O(lg n)
        TreeNode current = find(root, data);
        if (current == null) return null;
        if (current.right != null) return findMin(current.right);
        TreeNode successor = null;
        TreeNode ancestor = root;
        while (ancestor != current) {
            if (current.data < ancestor.data) {
                successor = ancestor;
                ancestor = ancestor.left;
            } else ancestor = ancestor.right;
        }
        return successor;
    }

    private static TreeNode findMin(TreeNode root) {    //O(lg n)
        while (root.left != null) root = root.left;
        return root;
    }

    private static TreeNode find(TreeNode root, int data) { //O(lg n)
        if (root == null) return null;
        if (data == root.data) return root;
        else if (data < root.data) return find(root.left, data);
        else return find(root.right, data);
    }
    
    /*class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int data) { this.data = data; }
    }*/
}
