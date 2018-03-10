def helper(left, right, s):
    if left == 0 and right == 0:
        print(s)
    if left > 0:
        helper(left - 1, right + 1, s + '(')
    if right > 0:
        helper(left, right - 1, s + ')')


def generate_all_brackets_combinations(n):
    helper(n, 0, '')


if __name__ == '__main__':
    generate_all_brackets_combinations(int(input('Enter an integer: ')))
