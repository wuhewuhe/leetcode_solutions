package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mac
 * 
 *         Given four lists A, B, C, D of integer values, compute how many
 *         tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is
 *         zero.
 * 
 *         To make problem a bit easier, all A, B, C, D have same length of N
 *         where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1
 *         and the result is guaranteed to be at most 231 - 1.
 * 
 *         Example:
 * 
 *         Input: A = [ 1, 2] B = [-2,-1] C = [-1, 2] D = [ 0, 2]
 * 
 *         Output: 2
 * 
 *         Explanation: The two tuples are: 1. (0, 0, 0, 1) -> A[0] + B[0] +
 *         C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0 2. (1, 1, 0, 0) -> A[1] + B[1]
 *         + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class FourSumII454 {
	/**
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		// corner case
		if (A == null || A.length == 0 || B == null || B.length == 0 || C == null || C.length == 0 || D == null
				|| D.length == 0)
			return 0;
		int res = 0;
		// map A B
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		//map C D
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				res += map.getOrDefault(-sum, 0);
			}
		}
		return res;

	}

}
