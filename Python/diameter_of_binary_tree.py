import sys


class TreeNode():
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def height(root):
    if not root:
        return 0
    return 1 + max(height(root.left), height(root.right))


def diameter(root):
    if not root:
        return 0
    ans = -1
    left, right = height(root.left), height(root.right)
    ans = max(ans, 1 + left + right)
    return ans

if __name__ == '__main__':
    root = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3))
    print(diameter(root))