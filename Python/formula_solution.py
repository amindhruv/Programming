def solutions(n):
    dict = {}
    for a in range(1, n):
        for b in range(a + 1, n + 1):
            total = a ** 3 + b ** 3
            if total in dict:
                arr = dict[total]
                for i in arr:
                    print(a, b, i[0], i[1])
            else:
                dict[total] = []
            dict[total].append((a, b))


if __name__ == '__main__':
    solutions(1000)
