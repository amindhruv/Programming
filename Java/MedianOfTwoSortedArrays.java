public class MedianOfTwoSortedArrays {
    private static double medianOfTwoSortedArrays(int[] first, int[] second) {
        if (first.length > second.length)
            medianOfTwoSortedArrays(second, first);    // To always assure- first array size not bigger than second one

        int x = first.length, y = second.length, low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2, partitionY = (x + y + 1) / 2 - partitionX;
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : first[partitionX - 1];    // Nothing on the left side
            int minRightX = partitionX == x ? Integer.MAX_VALUE : first[partitionX];    // Nothing on the right side
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : second[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : second[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {    // Partitioned arrays correctly
                if ((x + y) % 2 == 0)    // If total array size is even
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                else    // If total array size is odd
                    return (double) Math.max(maxLeftX, maxLeftY);
            } else if (maxLeftX > minRightY)    // Too far on right side of partitionX, go left
                high = partitionX - 1;
            else    // Too far on left side of partitionX, go right
                low = partitionX + 1;
        }
        throw new IllegalArgumentException();    // Throw error only when given arrays aren't already sorted!
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15}, y = {7, 11, 18, 19, 21, 25};    // Odd total length
        // int[] x = {1, 3, 8, 9, 15, 26}, y = {7, 11, 18, 19, 21, 25};    // Even total length
        System.out.println(medianOfTwoSortedArrays(x, y));
    }
}
