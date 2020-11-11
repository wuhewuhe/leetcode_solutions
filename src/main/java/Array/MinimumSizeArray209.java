package Array;

import org.junit.Test;

/**
 * @author mac
 * 
 * 
 *         Given an array of n positive integers and a positive integer s, find
 *         the minimal length of a contiguous subarray of which the sum ≥ s. If
 *         there isn't one, return 0 instead.
 * 
 *         Example:
 * 
 *         Input: s = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: the
 *         subarray [4,3] has the minimal length under the problem constraint.
 *         Follow up: If you have figured out the O(n) solution, try coding
 *         another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeArray209 {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int len = nums.length, left = 0, count = 0, res = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			count += nums[i];
			while (count >= s) {
				count -= nums[left];
				if (count < s) {
					res = Math.min(res, i + 1 - left);
				}
				left++;
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	@Test
	public void test() {
		int s = 7;
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen(s, nums));
	}
}
