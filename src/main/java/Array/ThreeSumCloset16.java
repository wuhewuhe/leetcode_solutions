package Array;

import java.util.Arrays;

import org.junit.Test;

public class ThreeSumCloset16 {
	public int threeSumClosest(int[] nums, int target) {
		// corner case
		if (nums == null || nums.length < 3)
			return 0;
		int diff = Integer.MAX_VALUE;
		int sum = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(target - sum) < Math.abs(diff)) {
					diff = target - sum;
					if(diff == 0)
						return target;
				}
				if (sum < target)
					left++;
				else
					right--;
			}
		}
		return target - diff;
	}

	@Test
	public void test() {
		int[] nums = { -1, 2, 0, 1, -4 };
		int target = 1;
		System.out.println(threeSumClosest(nums, target));
	}

}
