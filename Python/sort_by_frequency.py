def sort_by_frequency(nums):
    counts = {}
    for num in nums:
        if num in counts:
            counts[num] += 1
        else:
            counts[num] = 1
    pairs = []
    for k, v in counts.items():
        pairs.append((k, v))
    pairs.sort(key=lambda p: p[0])
    pairs.sort(key=lambda p: p[1], reverse=True)
    for pair in pairs:
        for i in range(pair[1]):
            print(pair[0], end=' ')
    print()


if __name__ == '__main__':
    nums = [2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12]
    sort_by_frequency(nums)
