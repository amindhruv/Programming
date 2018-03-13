import java.util.ArrayList;
import java.util.List;

public class NodesAtKDistanceFromLeaves {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), null), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7, null, new TreeNode(9, null, new TreeNode(10)))));
        kDistanceFromLeaves(root, 2).forEach(System.out::println);
    }
    
    private static List<Integer> kDistanceFromLeaves(TreeNode root, int k) {
	    List<Integer> ans = new ArrayList<>();
    	if (root == null) return ans;
    	helper(root, k, new ArrayList<TreeNode>(), new ArrayList<Boolean>(), ans);
    	return ans;
    }
    
    private static void helper(TreeNode root, int k, List<TreeNode> nodes, List<Boolean> visited, List<Integer> ans) {
    	if (root == null) return;
    	nodes.add(root);
    	visited.add(false);
    	int currSize = nodes.size();
    	if (root.left == null && root.right == null && currSize > k && !visited.get(currSize - k - 1)) {
    		ans.add(nodes.get(currSize - k - 1).value);
    		visited.set(currSize - k - 1, true);
    	}
    	helper(root.left, k, nodes, visited, ans);
    	helper(root.right, k, nodes, visited, ans);
    	nodes.remove(currSize - 1); 
        visited.remove(currSize - 1);
    }
    
    static class TreeNode {
        int value;
    	TreeNode left, right;
    	TreeNode(int value, TreeNode left, TreeNode right) {
    		this.value = value;
    		this.left = left;
    		this.right = right;
    	}
    	TreeNode(int value) { this.value = value; }
    }
}
