def counting_sort(sort_this, max_value):
    result, count = [0] * len(sort_this), [0] * (max_value + 1)
    for num in sort_this:
        count[num] += 1
    for i in range(max_value):
        count[i + 1] += count[i]
    for num in sort_this:
        result[count[num] - 1] = num
    return result


if __name__ == '__main__':
    with open('inp') as f:
        line = f.readlines()
    nums = [int(i) for i in line]
    print(counting_sort(nums, max(nums)))
