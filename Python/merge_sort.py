def merge_sort(sort_this, low, high):
    if low < high:
        mid = (low + high) // 2
        merge_sort(sort_this, low, mid)
        merge_sort(sort_this, mid + 1, high)
        merge(sort_this, low, mid, high)


def merge(merge_this, low, mid, high):
    temp = merge_this[:]
    i, j, k = low, mid + 1, low
    while i <= mid and j <= high:
        if temp[i] <= temp[j]:
            merge_this[k] = temp[i]
            i += 1
        else:
            merge_this[k] = temp[j]
            j += 1
        k += 1
    while i <= mid:
        merge_this[k] = temp[i]
        i += 1
        k += 1


if __name__ == '__main__':
    with open('inp') as f:
        line = f.readlines()
    nums = [int(i) for i in line]
    merge_sort(nums, 0, len(nums) - 1)
    print(nums)
