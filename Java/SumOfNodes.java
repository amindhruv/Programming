public class SumOfNodes {
    public static void main(String[] args) {
        CreateBST.Node root = new CreateBST.Node(1);
        root.left = new CreateBST.Node(2);
        root.right = new CreateBST.Node(3);
        root.left.left = new CreateBST.Node(4);
        root.left.right = new CreateBST.Node(5);
        root.right.left = new CreateBST.Node(6);
        root.right.right = new CreateBST.Node(7);
        System.out.println("Sum of all nodes: " + sumOfNodes(root));
        System.out.println("Sum of all even nodes: " + sumOfEvenNodes(root));
        System.out.println("Sum of all odd nodes: " + sumOfOddNodes(root));
        System.out.print("Sum of even nodes at each node: ");
        printEachEvenSum(root);
        System.out.println();
        System.out.print("Sum of odd nodes at each node: ");
        printEachOddSum(root);
        System.out.println();
    }

    private static int sumOfNodes(CreateBST.Node root) {
        return root == null ? 0 : root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    private static int sumOfEvenNodes(CreateBST.Node root) {
        if (root == null)
            return 0;
        return (root.data % 2 != 0 ? 0 : root.data) + sumOfEvenNodes(root.left) + sumOfEvenNodes(root.right);
    }

    private static int sumOfOddNodes(CreateBST.Node root) {
        if (root == null)
            return 0;
        return (root.data % 2 == 0 ? 0 : root.data) + sumOfOddNodes(root.left) + sumOfOddNodes(root.right);
    }

    private static int printEachEvenSum(CreateBST.Node root) {
        if (root == null)
            return 0;
        int sum = (root.data % 2 == 0 ? root.data : 0) + printEachEvenSum(root.left) + printEachEvenSum(root.right);
        if (sum != 0)
            System.out.print(sum + " ");
        return sum;
    }

    private static int printEachOddSum(CreateBST.Node root) {
        if (root != null) {
            int sum = (root.data % 2 != 0 ? root.data : 0) + printEachOddSum(root.left) + printEachOddSum(root.right);
            if (sum != 0)
                System.out.print(sum + " ");
            return sum;
        }
        return 0;
    }
}
