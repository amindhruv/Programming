def max_sum_subarray(array):
    total, answer = array[0], array[0]
    for i in range(1, len(array)):
        total = max(array[i], total + array[i])
        answer = max(answer, total)
    return answer


print(max_sum_subarray([1, -3, 2, -5, 7, 6, -1, -4, 11, -23]))
