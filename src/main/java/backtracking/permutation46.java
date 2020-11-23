package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * @author mac Given an array nums of distinct integers, return all the possible
 *         permutations. You can return the answer in any order.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: nums = [1,2,3] Output:
 *         [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] Example 2:
 * 
 *         Input: nums = [0,1] Output: [[0,1],[1,0]] Example 3:
 * 
 *         Input: nums = [1] Output: [[1]]
 */
public class permutation46 {
	// DFS + backtracking
	public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0)
			return new LinkedList();
		List<List<Integer>> res = new ArrayList<>();
		backtrack(nums, res, new LinkedList<Integer>(), new HashSet<Integer>());
		return res;
	}

	private void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> curr, HashSet<Integer> set) {
		// return one result
		if (curr.size() == nums.length) {
			res.add(new LinkedList<Integer>(curr));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i])) {
				curr.add(nums[i]);
				int last = curr.size() - 1;
				set.add(nums[i]);
				backtrack(nums, res, curr, set);
				set.remove(nums[i]);
				curr.remove(last);
			}
		}
	}

	public List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length == 0) {
			return res;
		}

		collectPermutations(nums, 0, new ArrayList<>(), res);
		return res;
	}

	private void collectPermutations(int[] nums, int start, List<Integer> curr, List<List<Integer>> res) {

		if (curr.size() == nums.length) {
			res.add(curr);
			return;
		}

		for (int i = 0; i <= curr.size(); i++) {
			List<Integer> newPermutation = new ArrayList<>(curr);
			newPermutation.add(i, nums[start]);
			collectPermutations(nums, start + 1, newPermutation, res);
		}
	}

	@Test
	public void test() {
		int[] nums = { 1, 2, 3 };
		System.out.println(permute2(nums));
	}
}
