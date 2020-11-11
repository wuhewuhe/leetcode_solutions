package Array;

import org.junit.Test;

/**
 * @author mac
 * 
 *         Given n non-negative integers representing an elevation map where the
 *         width of each bar is 1, compute how much water it can trap after
 *         raining.
 * 
 *         Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6 Explanation: The
 *         above elevation map (black section) is represented by array
 *         [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
 *         section) are being trapped.
 */
public class TrapRainWater42 {

	/**
	 * @param height
	 * @return
	 * 
	 *         1 brute force
	 */
	public int trap(int[] height) {
		// corner case
		if (height == null || height.length == 0)
			return 0;
		int res = 0;
		for (int i = 0; i < height.length; i++) {
			int left_max = 0, right_max = 0;
			for (int j = 0; j <= i && i > 0; j++) {
				left_max = Math.max(left_max, height[j]);
			}
			for (int j = height.length - 1; j >= i && i < height.length - 1; j--) {
				right_max = Math.max(right_max, height[j]);
			}
			int temp = Math.min(right_max, left_max) - height[i];
			res = temp > 0 ? res + temp : res;
		}
		return res;
	}

	/**
	 * @param height
	 * @return
	 * 
	 *         performance O(n)
	 */
	public int trap2(int[] height) {
		// corner case
		if (height == null || height.length == 0)
			return 0;
		int[] left_max = new int[height.length];
		int[] right_max = new int[height.length];
		int left = height[0], right = height[height.length - 1];
		int res = 0;
		for (int i = 1; i < height.length; i++) {
			if (height[i] > left)
				left = Math.max(left, height[i]);
			left_max[i] = left;
		}
		for (int i = height.length - 2; i >= 0; i--) {
			if (height[i] > right)
				right = Math.max(right, height[i]);
			right_max[i] = right;
		}
		for (int i = 0; i < height.length; i++) {
			int temp = Math.min(right_max[i], left_max[i]) - height[i];
			res = temp > 0 ? res + temp : res;
		}
		return res;
	}

	/**
	 * @param height
	 * @return
	 * 
	 *         two pointer
	 */
	public int trap3(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int left = 0, right = height.length - 1;
		int left_max = 0, right_max = 0;
		int res = 0;
		while (left < right) {
			left_max = Math.max(left_max, height[left]);
			right_max = Math.max(right_max, height[right]);
			if (left_max < right_max) {
				int temp = left_max - height[left];
				if (temp > 0)
					res += temp;
			} else {
				int temp = right_max - height[right];
				if (temp > 0)
					res += temp;
			}
		}
		return res;
	}

	@Test
	public void test() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap2(height));
	}
}
