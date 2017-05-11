def partition(partition_this, low, high):
    pivot = partition_this[low]
    i = low + 1
    for j in range(low + 1, high):
        if partition_this[j] < pivot:
            partition_this[j], partition_this[i] = partition_this[i], partition_this[j]
            i += 1
    partition_this[low], partition_this[i - 1] = partition_this[i - 1], partition_this[low]
    return i - 1


def quick_sort(sort_this, low, high):
    if low < high:
        pivot = partition(sort_this, low, high)
        quick_sort(sort_this, low, pivot)
        quick_sort(sort_this, pivot + 1, high)


if __name__ == '__main__':
    with open('inp') as f:
        line = f.readlines()
    nums = [int(i) for i in line]
    quick_sort(nums, 0, len(nums))
    print(nums)
