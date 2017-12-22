def largest_histogram_area(histogram):
    i, maxArea, st = 0, 0, []
    while i < len(histogram):
        if len(st) == 0 or histogram[st[-1]] <= histogram[i]:
            st.append(i)
            i += 1
        else:
            top = st.pop()
            area = histogram[top] * (i if len(st) == 0 else i - st[-1] - 1)
            if area > maxArea:
                maxArea = area
    while len(st):
        top = st.pop()
        area = histogram[top] * (i if len(st) == 0 else i - st[-1] - 1)
        if area > maxArea:
            maxArea = area
    return maxArea


if __name__ == '__main__':
    histogram = [6, 2, 5, 4, 5, 1, 6]
    print(largest_histogram_area(histogram))
