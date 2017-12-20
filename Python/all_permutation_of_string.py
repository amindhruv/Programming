def permutation(s):
    helper('', s)

def helper(prefix, s):
    n = len(s)
    if n == 0:
        print(prefix)
    else:
        for i in range(n):
            helper(prefix + s[i], s[:i] + s[i + 1:])


if __name__ == '__main__':
    permutation('abc')
