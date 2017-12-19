public class SortedArraysUnionIntersection {
	public static void main(String[] args) {
		int[] first = {13, 27, 35, 40, 49, 55, 59}, second = {17, 35, 39, 40, 55, 58, 59, 60};
		union(first, second);
		intersection(first, second);
	}

	private static void union(int[] first, int[] second) {
		int i = 0, j = 0, m = first.length, n = second.length;
		while (i < m && j < n) {
			if (first[i] < second[j]) {
				System.out.print(first[i++] + " ");
			} else if (first[i] > second[j]) {
				System.out.print(second[j++] + " ");
			} else {
				System.out.print(first[i++] + " ");
				j++;
			}
		}
		while (i < m) {
			System.out.print(first[i++] + " ");
		}
		while (j < n) {
			System.out.print(second[j++] + " ");
		}
		System.out.println("<-- Union");
	}

	private static void intersection(int[] first, int[] second) {
		int i = 0, j = 0, m = first.length, n = second.length;
		while (i < m && j < n) {
			if (first[i] < second[j]) {
				i++;
			} else if (first[i] > second[j]) {
				j++;
			} else {
				System.out.print(first[i++] + " ");
				j++;
			}
		}
		System.out.println("<-- Intersection");
	}
}
