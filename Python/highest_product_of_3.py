def highest_product_of_3(list_of_ints):
    # By sorting with O(n*logn) time and O(1) space complexity
    # n = len(list_of_ints)
    # list_of_ints.sort()
    # return max(list_of_ints[0] * list_of_ints[1] * list_of_ints[n - 1], list_of_ints[n - 3] * list_of_ints[n - 2] * list_of_ints[n - 1])

    # Greedy approach with O(n) time and O(1) space complexity
    n = len(list_of_ints)
    if n < 3:
        raise ValueError('Unable to find such product for less than 3 numbers in input!')
    lowest = min(list_of_ints[0], list_of_ints[1])
    highest = max(list_of_ints[0], list_of_ints[1])
    lowest_product_of_2 = list_of_ints[0] * list_of_ints[1]
    highest_product_of_2 = list_of_ints[0] * list_of_ints[1]
    max_product = list_of_ints[0] * list_of_ints[1] * list_of_ints[2]
    for i in xrange(2, n):
        current = list_of_ints[i]
        max_product = max(max_product, current * highest_product_of_2, current * lowest_product_of_2)
        lowest_product_of_2 = min(lowest_product_of_2, current * lowest, current * highest)
        highest_product_of_2 = max(highest_product_of_2, current * lowest, current * highest)
        lowest = min(lowest, current)
        highest = max(highest, current)
    return max_product


if __name__ == '__main__':
    list_of_ints = [-10, -10, 1, 3, 2]
    print highest_product_of_3(list_of_ints)
