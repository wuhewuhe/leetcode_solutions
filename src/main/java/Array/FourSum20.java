package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author mac
 * 
 *         Given an array nums of n integers and an integer target, are there
 *         elements a, b, c, and d in nums such that a + b + c + d = target?
 *         Find all unique quadruplets in the array which gives the sum of
 *         target.
 * 
 *         Notice that the solution set must not contain duplicate quadruplets.
 */
public class FourSum20 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList();
		if (nums == null || nums.length < 4)
			return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			// performance
			if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target)
				continue;
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
				continue;
			// skip same result
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				// performance
				if (nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target)
					continue;
				if (nums[i] + nums[j] + nums[i + 2] + nums[i + 3] > target)
					continue;
				// skip same result
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int left = j + 1, right = nums.length - 1;
				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum < target)
						left++;
					else if (sum > target)
						right--;
					else {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						left++;
						right--;
						while (left < right && nums[left] == nums[left - 1])
							left++;
						while (left < right && nums[right] == nums[right + 1])
							right--;
					}
				}
			}
		}
		return res;
	}

	@Test
	public void test() {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		System.out.println(fourSum(nums, target));
	}
}
