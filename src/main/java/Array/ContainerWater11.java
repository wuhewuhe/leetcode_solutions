package Array;

import org.junit.Test;

/**
 * @author mac
 * 
 *         Given n non-negative integers a1, a2, ..., an , where each represents
 *         a point at coordinate (i, ai). n vertical lines are drawn such that
 *         the two endpoints of the line i is at (i, ai) and (i, 0). Find two
 *         lines, which, together with the x-axis forms a container, such that
 *         the container contains the most water.
 * 
 *         Notice that you may not slant the container.
 * 
 *         height = [1,8,6,2,5,4,8,3,7] Output: 49
 */
public class ContainerWater11 {
	/**
	 * @param array height
	 * @return max area two pointer
	 */
	public int maxArea(int[] height) {
		// corner case
		if (height == null || height.length < 2)
			return 0;
		int sum = 0, left = 0, right = height.length - 1;
		while (left < right) {
			int length = right - left;
			int area = Math.min(height[right], height[left]) * length;
			sum = Math.max(sum, area);
			if (height[right] < height[left]) {
				right--;
			} else
				left++;
		}
		return sum;
	}

	/**
	 * @param array height
	 * @return max area bruce force
	 */
	public int maxArea2(int[] height) {
		// corner case
		if (height == null || height.length < 2)
			return 0;
		int sum = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int length = j - i;
				int area = Math.min(height[i], height[j]) * length;
				sum = Math.max(sum, area);
			}
		}
		return sum;
	}

	@Test
	public void test() {
		int[] nums = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(nums));
	}
}
