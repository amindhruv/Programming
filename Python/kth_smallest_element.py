def partition(nums, left, right):
    pivot, i = nums[right], left
    for j in range(left, right):
        if nums[j] < pivot:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
    nums[i], nums[right] = nums[right], nums[i]
    return i


def quick_sort(nums, left, right, k):
    if left > right: return
    pivot = partition(nums, left, right)
    if pivot == k - 1:
        return nums[pivot]
    if pivot < k - 1:
        return quick_sort(nums, pivot + 1, right, k)
    return quick_sort(nums, left, pivot - 1, k)


def kth_smallest(nums, k):
    if k < 1 or k > len(nums):
        return
    return quick_sort(nums, 0, len(nums) - 1, k)


if __name__ == '__main__':
    nums = [2, 6, 7, 9, 0, 4, 8]
    print(kth_smallest(nums, 3))