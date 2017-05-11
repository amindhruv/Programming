def binary_search(array, desired):
    low, high = 0, len(array) - 1
    while low <= high:
        mid = (low + high) // 2
        if array[mid] == desired:
            return mid
        elif array[mid] < desired:
            low = mid + 1
        else:
            high = mid - 1
    return -1

if __name__ == '__main__':
    nums = [2, 3, 5, 6, 8, 10]
    print(binary_search(nums, 10))
    print(binary_search(nums, 11))
