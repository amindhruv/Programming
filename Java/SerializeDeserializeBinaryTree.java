public class SerializeDeserializeBinaryTree {
  public String serialize(TreeNode root) {
    if (root == null) return "";
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        sb.append(node.value + ",");
        queue.offer(node.left);
        queue.offer(node.right);
      } else
        sb.append("#,");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  public TreeNode deserialize(String data) {
    if (data == null || data.equals("")) return null;
    String[] nodes = data.split(",");
    TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int i = 1;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) continue;
      if (!nodes[i].equals("#")) {
        node.left = new TreeNode(Integer.valueOf(nodes[i]));
        queue.offer(nodes.left);
      } else {
        node.left = null;
        queue.offer(null);
      }
      i++;
      if (!nodes[i].equals("#")) {
        node.right = new TreeNode(Integer.valueOf(nodes[i]));
        queue.offer(nodes.right);
      } else {
        node.right = null;
        queue.offer(null);
      }
      i++;
    }
    return root;
  }
}
