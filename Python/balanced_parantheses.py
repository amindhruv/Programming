def balanced_parantheses(check_this):
    stack = []
    open_bracs = ['(', '{', '[']
    close_bracs = [')', '}', ']']
    pair = {')': '(', '}': '{', ']': '['}
    for ch in check_this:
        if ch in open_bracs:
            stack.append(ch)
        elif ch in close_bracs:
            if len(stack) == 0 or pair[ch] != stack[-1]:
                return False
            else:
                stack.pop()
    return len(stack) == 0


if __name__ == '__main__':
    print(balanced_parantheses(input()))
