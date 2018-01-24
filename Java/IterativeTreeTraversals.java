import java.util.Stack;

public class IterativeTreeTraversals {
    static class TreeNode {
        int value;
        TreeNode left, right;
        TreeNode(int value) {
            this.value = value;
        }
        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void main(String args[]) {
        IterativeTreeTraversals itt = new IterativeTreeTraversals();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6, new TreeNode(5), new TreeNode(7)));
        itt.preOrder(root);
        itt.inOrder(root);
        itt.postOrder(root);
    }
    
    private void preOrder(TreeNode root) {
    	if (root == null) return;
    	Stack<TreeNode> st = new Stack<>();
    	st.push(root);
    	while (!st.isEmpty()) {
    		root = st.pop();
    		System.out.print(root.value + " ");
    		if (root.right != null) st.push(root.right);
    		if (root.left != null) st.push(root.left);
    	}
    	System.out.println("<-- Pre Order Traversal");
    }
    
    private void inOrder(TreeNode root) {
    	if (root == null) return;
    	Stack<TreeNode> st = new Stack<>();
    	while (!st.isEmpty() || root != null) {
    		if (root != null) {
    			st.push(root);
    			root = root.left;
    		} else {
    			root = st.pop();
    			System.out.print(root.value + " ");
    			root = root.right;
    		}
    	}
    	System.out.println("<-- In Order Traversal");
    }
    
    
    private void postOrder(TreeNode root) {
    	if (root == null) return;
    	Stack<TreeNode> st = new Stack<>();
    	st.push(root);
    	TreeNode prev = null;
    	while (!st.isEmpty()) {
    		TreeNode curr = st.peek();
    		if (prev == null || curr == prev.left || curr == prev.right) {
    			if (curr.left != null) st.push(curr.left);
    			else if (curr.right != null) st.push(curr.right);
    		} else if (curr.left == prev) {
    			if (curr.right != null) st.push(curr.right);
    		} else {
    			System.out.print(st.pop().value + " ");
    		}
    		prev = curr;
    	}
    	System.out.println("<-- Post Order Traversal");
    }
}
