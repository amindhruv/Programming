public class TernaryToBinaryTree {
    public static void main(String []args) {
        print(ternaryToTree("a?b:c".toCharArray()));
        System.out.println();
        print(ternaryToTree("a?b?c:d:e".toCharArray()));
        System.out.println();
        print(ternaryToTree("a?b?c?d:e:f:g".toCharArray()));
        System.out.println();
        print(ternaryToTree("a?b:c?d:e".toCharArray()));
        System.out.println();
        print(ternaryToTree("a?b:c?d:e?f:g".toCharArray()));
        System.out.println();
        print(ternaryToTree("a?b?c?d:e:f?g:h:i?j:k".toCharArray()));
    }
    
    private static TreeNode ternaryToTree(char[] expression) {
        if (expression.length == 0) return null;
        TreeNode root = new TreeNode(expression[0]);
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        for (int i = 1; i < expression.length; i += 2) {
            TreeNode node = new TreeNode(expression[i + 1]);
            if (expression[i] == '?') {
                st.peek().left = node;
            } else if (expression[i] == ':') {
                st.pop().right = node;
            }
            st.push(node);
        }
        return root;
    }
    
    private static void print(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        if (root.left != null) {
            System.out.print("? ");
            print(root.left);
        }
        if (root.right != null) {
            System.out.print(": ");
            print(root.right);
        }
    }
    
    static class TreeNode {
        char data;
        TreeNode left, right;
        TreeNode(char ch) {
            this.data = ch;
        }
    }
}
