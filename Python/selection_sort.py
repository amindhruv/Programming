def selection_sort(sort_this):
    n = len(sort_this)
    for i in range(n - 1):
        min_index = i
        for j in range(i + 1, n):
            if sort_this[j] < sort_this[min_index]:
                min_index = j
        temp = sort_this[i]
        sort_this[i] = sort_this[min_index]
        sort_this[min_index] = temp


if __name__ == '__main__':
    with open('inp') as f:
        line = f.readlines()
    nums = [int(i) for i in line]
    selection_sort(nums)
    print(nums)
