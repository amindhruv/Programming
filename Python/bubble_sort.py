def bubble_sort(sort_this):
    n = len(sort_this)
    for i in range(1, n):
        flag = False
        for j in range(n - i):
            if sort_this[j] > sort_this[j + 1]:
                flag = True
                sort_this[j], sort_this[j + 1] = sort_this[j + 1], sort_this[j]
        if not flag:
            break


if __name__ == '__main__':
    with open('inp') as f:
        line = f.readlines()
    nums = [int(i) for i in line]
    bubble_sort(nums)
    print(nums)
