package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author mac
 * 
 *         Given an array nums of n integers, are there elements a, b, c in nums
 *         such that a + b + c = 0? Find all unique triplets in the array which
 *         gives the sum of zero.
 * 
 *         Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Example
 *         2:
 * 
 *         Input: nums = [] Output: [] Example 3:
 * 
 *         Input: nums = [0] Output: []
 */
public class ThreeSum15 {
	/**
	 * @param array nums
	 * @return index of three number
	 */
//	public List<List<Integer>> threeSum(int[] nums) {
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		// corner case
//		if (nums == null || nums.length < 3)
//			return res;
//		Arrays.sort(nums);
//		int length = nums.length - 1;
//		for (int i = 0; i < nums.length - 2; i++) {
//			// always < 0
//			if (nums[i] + nums[length - 1] + nums[length] < 0)
//				continue;
//			// always > 0
//			if (nums[i] + nums[i + 1] + nums[i + 2] > 0)
//				continue;
//			// skip the same result target
//			if (i > 0 && nums[i] == nums[i - 1])
//				continue;
//			int left = i + 1, right = length;
//			while (left < right) {
//				if (nums[i] + nums[left] + nums[right] < 0) {
//					left++;
//				} else if (nums[i] + nums[left] + nums[right] > 0) {
//					right--;
//				} else {
//					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//					left++;
//					right--;
//					// skip the same result left
//					while (left < right && nums[left] == nums[left - 1]) {
//						left++;
//					}
//					// skip the same result right
//					while (left < right && nums[right] == nums[right + 1]) {
//						right--;
//					}
//				}
//			}
//		}
//		return res;
//	}

	public List<List<Integer>> threeSum(int[] nums) {
		/*
		 * [-1,0,1,2,-1,-4] -> [-4,-1,-1,0,1,2,2] i =0; target = -1, left = i+1, right =
		 * length -1 if(left + right >target) right--; if(left+right < target) left++;
		 * if(left + right == target) res.add left++,right--; while i = 1: skip
		 */
		List<List<Integer>> res = new ArrayList();
		// corner case
		if (nums == null || nums.length < 3)
			return res;
		Arrays.sort(nums);
		int length = nums.length - 1;
		for (int i = 0; i <= length; i++) {
			if (nums[i] + nums[length - 1] + nums[length] < 0)
				continue;
			if (nums[i] + nums[i + 1] + nums[i + 2] > 0)
				continue;
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int target = nums[i];
			int left = i + 1, right = length;
			while (left < right) {
			}
			if (nums[left] + nums[right] > -target)
				right--;
			else if (nums[left] + nums[right] < -target)
				left++;
			else {
				res.add(Arrays.asList(nums[i], nums[left], nums[right]));
				left++;
				right--;
				while (left < right && nums[left - 1] == nums[left]) {
					left++;
				}
				while (left < right && nums[right + 1] == nums[right]) {
					right--;
				}
			}
		}
		return res;
	}

	@Test
	public void test() {
		int[] nums = { -1, 0, 1 };
		System.out.println(threeSum(nums));
	}
}
