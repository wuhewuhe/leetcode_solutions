package Permutation;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author mac Implement next permutation, which rearranges numbers into the
 *         lexicographically next greater permutation of numbers.
 * 
 *         If such an arrangement is not possible, it must rearrange it as the
 *         lowest possible order (i.e., sorted in ascending order).
 * 
 *         The replacement must be in place and use only constant extra memory.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: nums = [1,2,3] Output: [1,3,2] Example 2:
 * 
 *         Input: nums = [3,2,1] Output: [1,2,3] Example 3:
 * 
 *         Input: nums = [1,1,5] Output: [1,5,1] Example 4:
 * 
 *         Input: nums = [1] Output: [1]
 */
public class NextPermutation31 {
	public void nextPermutation(int[] nums) {
		// corenr case
		if (nums == null || nums.length <= 1)
			return;
		// find first descending order index i
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1])
			i--;
		// find the first index j larger than index i
		int j = nums.length - 1;
		if (i >= 0) {
			while (nums[j] <= nums[i])
				j--;
			// swap i and j
			swap(nums, i, j);
		}
		// Reverse the descending sequence from i + 1
		reverse(nums, i + 1, nums.length - 1);
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j)
			swap(nums, i++, j--);
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

	@Test
	public void test() {
		int[] nums = { 3, 2, 1 };
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
