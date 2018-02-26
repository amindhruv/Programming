import random


def get_random(floor, ceiling):
    return random.randrange(floor, ceiling + 1)


def inplace_shuffle(nums):
    n = len(nums)
    if n < 2:
        return nums
    for i in range(n - 1):
        random_index = get_random(i, n - 1)
        if i != random_index:
            nums[i], nums[random_index] = nums[random_index], nums[i]
    return nums


if __name__ == '__main__':
    print(inplace_shuffle([2, 6, 7, 9, 0, 4, 8]))