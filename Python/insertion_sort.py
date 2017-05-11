def insertion_sort(sort_this):
    n = len(sort_this)
    for i in range(1, n):
        j, pivot = i - 1, sort_this[i]
        while j >= 0 and sort_this[j] > pivot:
            sort_this[j + 1] = sort_this[j]
            j -= 1
        sort_this[j + 1] = pivot


if __name__ == '__main__':
    with open('inp') as f:
        line = f.readlines()
    nums = [int(i) for i in line]
    insertion_sort(nums)
    print(nums)
