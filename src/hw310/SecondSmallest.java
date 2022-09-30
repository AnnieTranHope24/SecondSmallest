package hw310;

public class SecondSmallest {

	/**
	 * Returns the second smallest element of an array a with n elements. If there
	 * are two or more of the smallest value in the array, that value should be
	 * returned. (e.g. If the array is [2, 5, 6, 2, 4, 3, 2], then 2 should be
	 * returned.)
	 */
	public static int secondSmallestA(int[] a, int n) {
		// Replace this with actual working code.
		int min = a[0];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] < min) {
				min = a[i];
				count = 1;
			} else if (a[i] == min) {
				count++;
			}
		}
		if (count >= 2) {
			return min;
		}
		int d = a[0] - min;
		int result = a[0];
		for (int i = 0; i < n; i++) {
			int temp = a[i] - min;
			if (d == 0 || ((temp <= d) && (temp != 0))) {
				d = temp;
				result = a[i];
			}

		}
		return result;
	}

	/**
	 * Returns the second smallest element of an array a with n elements. If there
	 * are two or more of the smallest value in the array, return the next larger
	 * value. (e.g. If the array is [2, 5, 6, 2, 4, 3, 2], then 3 should be
	 * returned.)
	 */
	public static int secondSmallestB(int[] a, int n) {
		// Replace this with actual working code.
		int min = a[0];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] < min) {
				min = a[i];
				count = 1;
			} else if (a[i] == min) {
				count++;
			}
		}
		int d = a[0] - min;
		int result = a[0];
		for (int i = 0; i < n; i++) {
			int temp = a[i] - min;
			if (d == 0 || ((temp < d) && (temp != 0))) {
				d = temp;
				result = a[i];
			}

		}
		return result;
	}

	public static void testSecondSmallestA() {
		// Test 1
		int[] array = new int[] { 2, 5, 6, 2, 4, 3, 2 };
		int expected = 2;
		int actual = secondSmallestA(array, array.length);
		checkCorrectness(expected, actual);

		// Test 2
		array = new int[] { 4, 43, 3, 598, 69, 48, 10, 9, 37, 4, 23, 3, 23, 43, 6, 4, 63, 898, 65, 5, 3, 32, 14 };
		expected = 3;
		actual = secondSmallestA(array, array.length);
		checkCorrectness(expected, actual);

		// Test 3
		array = new int[] { 43, 598, 69, 48, 10, 9, 37, 5, 23, 3, 23, 43, 6, 63, 898, 65, 4, 32, 14 };
		expected = 4;
		actual = secondSmallestA(array, array.length);
		checkCorrectness(expected, actual);

		// Test 4
		array = new int[] { 2, 3, 69, 48, 10, 9, 37, 4, 23, 33, 23, 43, 5, 63, 898, 65, 5, 32, 14 };
		expected = 3;
		actual = secondSmallestA(array, array.length);
		checkCorrectness(expected, actual);

		// Test 5
		array = new int[] { 3, 2, 69, 48, 10, 9, 37, 4, 23, 33, 23, 43, 5, 63, 898, 65, 5, 32, 14 };
		expected = 3;
		actual = secondSmallestA(array, array.length);
		checkCorrectness(expected, actual);

		// Test 6
		array = new int[] { 69, 48, 10, 9, 37, 4, 23, 33, 23, 43, 5, 63, 898, 65, 5, 32, 14, 3, 2 };
		expected = 3;
		actual = secondSmallestA(array, array.length);
		checkCorrectness(expected, actual);

		// Test 7
		array = new int[] { 69, 48, 10, 9, 37, 90, 23, 33, 23, 43, 6, 63, 898, 65, 6, 32, 14, 1, 5 };
		expected = 5;
		actual = secondSmallestA(array, array.length);
		checkCorrectness(expected, actual);

		// Test 8
		array = new int[] { 3, 48, 10, 9, 37, 90, 23, 33, 23, 43, 6, 63, 898, 65, 6, 32, 14, 2 };
		expected = 3;
		actual = secondSmallestA(array, array.length);
		checkCorrectness(expected, actual);

		// Test 9
		array = new int[] { 2, 48, 10, 9, 37, 90, 23, 33, 23, 43, 6, 63, 898, 65, 6, 32, 14, 5 };
		expected = 5;
		actual = secondSmallestA(array, array.length);
		checkCorrectness(expected, actual);

	}

	public static void testSecondSmallestB() {
		// Test 1
		int[] array = new int[] { 2, 5, 6, 2, 4, 3, 2 };
		int expected = 3;
		int actual = secondSmallestB(array, array.length);
		checkCorrectness(expected, actual);

		// Test 2
		array = new int[] { 43, 598, 69, 4, 10, 9, 37, 4, 23, 36, 23, 4, 16, 63, 898, 65, 55, 32, 4 };
		expected = 9;
		actual = secondSmallestB(array, array.length);
		checkCorrectness(expected, actual);

		// Test 3
		array = new int[] { 43, 598, 69, 48, 10, 9, 37, 5, 23, 3, 23, 43, 6, 63, 898, 65, 4, 32, 14 };
		expected = 4;
		actual = secondSmallestB(array, array.length);
		checkCorrectness(expected, actual);

		// Test 4
		array = new int[] { 2, 3, 69, 48, 10, 9, 37, 4, 23, 33, 23, 43, 5, 63, 898, 65, 5, 32, 14 };
		expected = 3;
		actual = secondSmallestB(array, array.length);
		checkCorrectness(expected, actual);

		// Test 5
		array = new int[] { 3, 2, 69, 48, 10, 9, 37, 4, 23, 33, 23, 43, 5, 63, 898, 65, 5, 32, 14 };
		expected = 3;
		actual = secondSmallestB(array, array.length);
		checkCorrectness(expected, actual);

		// Test 6
		array = new int[] { 69, 48, 10, 9, 37, 4, 23, 33, 23, 43, 5, 63, 898, 65, 5, 32, 14, 3, 2 };
		expected = 3;
		actual = secondSmallestB(array, array.length);
		checkCorrectness(expected, actual);

		// Test 7
		array = new int[] { 69, 48, 10, 9, 37, 90, 23, 33, 23, 43, 6, 63, 898, 65, 6, 32, 14, 1, 5 };
		expected = 5;
		actual = secondSmallestB(array, array.length);
		checkCorrectness(expected, actual);

		// Test 8
		array = new int[] { 3, 48, 10, 9, 37, 90, 23, 33, 23, 43, 6, 63, 898, 65, 6, 32, 14, 2 };
		expected = 3;
		actual = secondSmallestB(array, array.length);
		checkCorrectness(expected, actual);

		// Test 9
		array = new int[] { 2, 48, 10, 9, 37, 90, 23, 33, 23, 43, 6, 63, 898, 65, 6, 32, 14, 5 };
		expected = 5;
		actual = secondSmallestB(array, array.length);
		checkCorrectness(expected, actual);

		// Test 10
		array = new int[] { 8675309, 8675309, 8675309, 8675309, 8675310, 8675309, 8675309, 8675309, 8675309, 8675309 };
		expected = 8675310;
		actual = secondSmallestB(array, array.length);
		checkCorrectness(expected, actual);

	}

	private static void checkCorrectness(int expected, int actual) {
		if (expected != actual) {
			System.out.println("INCORRECT: Expected " + expected + " but was " + actual);
		} else {
			System.out.println("Correct answer of " + actual + " was returned");
		}
	}

	public static void main(String[] args) {
		System.out.println("Testing A:");
		testSecondSmallestA();
		System.out.println("\n\nTesting B:");
		testSecondSmallestB();
	}

}
