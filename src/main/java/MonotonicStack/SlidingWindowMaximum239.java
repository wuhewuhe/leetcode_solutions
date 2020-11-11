package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

/**
 * @author mac
 * 
 *         You are given an array of integers nums, there is a sliding window of
 *         size k which is moving from the very left of the array to the very
 *         right. You can only see the k numbers in the window. Each time the
 *         sliding window moves right by one position.
 * 
 *         Return the max sliding window.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [3,3,5,5,6,7]
 *         Explanation: Window position Max --------------- ----- [1 3 -1] -3 5
 *         3 6 7 3 1 [3 -1 -3] 5 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6
 *         7 5 1 3 -1 -3 [5 3 6] 7 6 1 3 -1 -3 5 [3 6 7] 7 Example 2:
 * 
 *         Input: nums = [1], k = 1 Output: [1] Example 3:
 * 
 *         Input: nums = [1,-1], k = 1 Output: [1,-1] Example 4:
 * 
 *         Input: nums = [9,11], k = 2 Output: [11] Example 5:
 * 
 *         Input: nums = [4,-2], k = 2 Output: [4]
 * 
 * 
 *         Constraints:
 * 
 *         1 <= nums.length <= 105 -104 <= nums[i] <= 104 1 <= k <= nums.length
 */
public class SlidingWindowMaximum239 {

	/**
	 * @param nums
	 * @param k
	 * @return
	 * 
	 *         brute force
	 * 
	 *         time complex O(nk) space complex O(k)
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length - k + 1;
		int[] res = new int[len];
		if (nums == null || nums.length < k)
			return res;
		int end = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			end = i + k;
			for (int j = i; j < end; j++) {
				max = Math.max(max, nums[j]);
			}
			res[i] = max;
			max = Integer.MIN_VALUE;
		}
		return res;
	}

	/**
	 * @param a
	 * @param k
	 * @return
	 * 
	 *         deque
	 * 
	 *         time complex O(n) space complex O(n)
	 */
	public int[] maxSlidingWindow1(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];
		// sorted index
		int[] res = new int[nums.length - k + 1];
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			// keep current window index
			while (!dq.isEmpty() && dq.peek() < i + 1 - k)
				dq.poll();
			// keep decrease stack
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
				dq.pollLast();
			dq.offer(i);
			if (i + 1 - k >= 0)
				res[i + 1 - k] = nums[dq.poll()];
		}
		return res;
	}

	/**
	 * @param nums
	 * @param k
	 * @return
	 * 
	 *         priority queue
	 * 
	 *         time complex O(nLogn) space complex O(n)
	 */
	public int[] maxSlidingWindow2(int[] nums, int k) {
		int[] res = new int[nums.length - k + 1];
		if (nums == null || nums.length == 0)
			return res;
		PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b) -> nums[b] - nums[a]);
		for (int i = 0; i < k; i++) {
			pq.offer(i);
		}
		res[0] = nums[pq.peek()];
		for (int i = k; i < nums.length; i++) {
			pq.offer(i);
			while (pq.peek() < (i - k + 1))
				pq.poll();
			res[i - k + 1] = nums[pq.peek()];
		}
		return res;
	}

	@Test
	public void test() {
		int[] nums = { 1, 3, 1, 2, 0, 5 };
		int k = 3;
		System.out.println(Arrays.toString(maxSlidingWindow1(nums, k)));
	}
}
