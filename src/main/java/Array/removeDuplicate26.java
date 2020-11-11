package Array;

import org.junit.Test;

public class removeDuplicate26 {
	public int removeDuplicates(int[] nums) {
		// corner case
		if (nums == null || nums.length == 0)
			return 0;
		int i = 1, res = 1;
		while (i < nums.length) {
			if (nums[i] != nums[i - 1])
				res++;
			i++;
		}
		return res;
	}

	@Test
	public void test() {
		int[] nums = { 0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(nums));
	}
}
