class BTNode():
    """Binary tree node"""
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def lowest_common_ancestor(root, first, second):
    if not root:
        return None
    if root == first or root == second:
        return root
    left = lowest_common_ancestor(root.left, first, second)
    right = lowest_common_ancestor(root.right, first, second)
    if left and right:
        return root
    if not left and not right:
        return None
    return left if left else right


if __name__ == '__main__':
    root = BTNode(3)
    root.left = BTNode(6, BTNode(2), BTNode(11, BTNode(9), BTNode(5)))
    root.right = BTNode(8, None, BTNode(13, BTNode(7)))
    """
        3
       / \
      6    8
     / \    \
    2  11   13
      / \   /
     9   5 7
    """
    print(lowest_common_ancestor(root, root.left.left, root.right).value)  # 2 8 -> 3
    print(lowest_common_ancestor(root, root.left.left, root.left.right.right).value)  # 2 5 -> 6
    print(lowest_common_ancestor(root, root.left.right.left, root.left.right.right).value)  # 9 5 -> 11
    print(lowest_common_ancestor(root, root.right, root.right.right.left).value)  # 8 7 -> 8
    print(lowest_common_ancestor(root, root.left.right.left, root).value)  # 9 3 -> 3
