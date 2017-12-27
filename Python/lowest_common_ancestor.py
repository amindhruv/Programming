class BSTNode():
    """Binary search tree node"""
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def lowest_common_ancestor(root, first, second):
    if root.value > max(first.value, second.value):
        return lowest_common_ancestor(root.left, first, second)
    elif root.value < min(first.value, second.value):
        return lowest_common_ancestor(root.right, first, second)
    else:
        return root.value


if __name__ == '__main__':
    root = BSTNode(10)
    root.left = BSTNode(-10, None, BSTNode(8, BSTNode(6), BSTNode(9)))
    root.right = BSTNode(30, BSTNode(25, None, BSTNode(28)), BSTNode(60, None, BSTNode(78)))
    """
         10
       /    \
    -10     30
      \     / \
       8   25 60
      / \   \   \
     6   9   28  78
    """
    print(lowest_common_ancestor(root, root.right.left.right, root.right.right.right))  # 28 78 -> 30
    print(lowest_common_ancestor(root, root.left.right.left, root.right))  # 6 30 -> 10
    print(lowest_common_ancestor(root, root.right, root.right.right.right))  # 30 78 -> 30
