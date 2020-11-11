package Array;

import org.junit.Test;

public class MaximumSubarray53 {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum >= 0 ? sum + nums[i] : nums[i];
			max = Math.max(sum, max);
		}
		return max;
	}

	/**
	 * @param nums
	 * @return
	 * 
	 *         DP
	 */
	public int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(dp[i], max);
		}
		return max;
	}

	@Test
	public void test() {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray2(nums));
	}
}
