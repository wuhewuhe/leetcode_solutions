package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author mac A message containing letters from A-Z is being encoded to numbers
 *         using the following mapping:
 * 
 *         'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given a non-empty string containing
 *         only digits, determine the total number of ways to decode it.
 * 
 *         The answer is guaranteed to fit in a 32-bit integer.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: s = "12" Output: 2 Explanation: It could be decoded as "AB" (1
 *         2) or "L" (12). Example 2:
 * 
 *         Input: s = "226" Output: 3 Explanation: It could be decoded as "BZ"
 *         (2 26), "VF" (22 6), or "BBF" (2 2 6). Example 3:
 * 
 *         Input: s = "0" Output: 0 Explanation: There is no character that is
 *         mapped to a number starting with '0'. We cannot ignore a zero when we
 *         face it while decoding. So, each '0' should be part of "10" --> 'J'
 *         or "20" --> 'T'. Example 4:
 * 
 *         Input: s = "1" Output: 1
 * 
 * 
 *         Constraints:
 * 
 *         1 <= s.length <= 100 s contains only digits and may contain leading
 *         zero(s).
 */

public class DecodeString94 {

	/**
	 * @param s
	 * @return
	 * 
	 * 
	 *         dp time complex O(n)
	 */
	public int numDecodings(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		// DP array to store the subproblem results
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		// Ways to decode a string of size 1 is 1. Unless the string is '0'.
		// '0' doesn't have a single digit decode.
		dp[1] = s.charAt(0) == '0' ? 0 : 1;

		for (int i = 2; i < dp.length; i++) {

			// Check if successful single digit decode is possible.
			if (s.charAt(i - 1) != '0') {
				dp[i] += dp[i - 1];
			}

			// Check if successful two digit decode is possible.
			int twoDigit = Integer.valueOf(s.substring(i - 2, i));
			if (twoDigit >= 10 && twoDigit <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];

	}

	private int recursiveWithMemo(int index, String str, Map<Integer, Integer> memo) {

		// If you reach the end of the string
		// Return 1 for success.
		if (index == str.length()) {
			return 1;
		}

		// If the string starts with a zero, it can't be decoded
		if (str.charAt(index) == '0') {
			return 0;
		}

		if (index == str.length() - 1) {
			return 1;
		}

		// Memoization is needed since we might encounter the same sub-string.
		if (memo.containsKey(index)) {
			return memo.get(index);
		}

		int ans = recursiveWithMemo(index + 1, str, memo);
		if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
			ans += recursiveWithMemo(index + 2, str, memo);
		}

		// Save for memoization
		memo.put(index, ans);

		return ans;
	}

	/**
	 * @param s
	 * @return
	 * 
	 *         recursion
	 */
	public int numDecodings2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		HashMap<Integer, Integer> memo = new HashMap<>();
		return recursiveWithMemo(0, s, memo);
	}

	@Test
	public void test() {
		String s = "226";
		System.out.println(numDecodings(s));
	}
}
