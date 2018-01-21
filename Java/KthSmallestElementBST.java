import java.util.Scanner;
import java.util.Stack;

public class KthSmallestElementBST {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6, new TreeNode(5), new TreeNode(7)));
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();
        sc.close();
        System.out.println("Result: " + kthSmallestElement(root, k));
    }

    private static int kthSmallestElement(TreeNode root, int k) {
        int count = 0;
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                if (++count == k)
                    return node.value;
                current = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }
}
