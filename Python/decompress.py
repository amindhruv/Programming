def decompress(compressed):
    result, int_stack, str_stack, n = '', [], [], 0
    for ch in compressed:
        if ch.isdigit():
            n = n * 10 + int(ch)
        elif ch == '[':
            int_stack.append(n)
            str_stack.append(result)
            result, n = '', 0
        elif ch == ']':
            n, s = int_stack.pop(), str_stack.pop()
            result = s + n * result
            n = 0
        else:
            result += ch
    return result


if __name__ == '__main__':
  print(decompress('3[abc]4[ab]c')) # -> abcabcabcababababc
  print(decompress('10[a]'))        # -> aaaaaaaaaa
  print(decompress('2[3[a]b]'))     # -> aaabaaab
  print(decompress('2[c3[a]b]'))    # -> caaabcaaab
