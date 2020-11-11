package SlidingWindow_TwoPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class LongestSubstringWithoutRepeat3 {
	public int lengthOfLongestSubstring(String s) {
		// corner case
		if (s == null || s.length() == 0)
			return 0;
		int max = 0;
		Set<Character> set = new HashSet<Character>();
		int left = 0, right = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			if (!set.contains(c)) {
				set.add(c);
				max = Math.max(max, set.size());
				right++;
			} else {
				set.remove(s.charAt(left));
				left++;
			}
		}
		return max;
	}

	/**
	 * @param s
	 * @return
	 * 
	 *         hashmap
	 */
	public int lengthOfLongestSubstring3(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	public int lengthOfLongestSubstring2(String s) {
		int n = s.length(), ans = 0;
		int[] index = new int[128]; // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			char c = s.charAt(j);
			i = Math.max(index[c], i);
			ans = Math.max(ans, j - i + 1);
			index[c] = j + 1;
		}
		return ans;
	}

	/**
	 * @param s
	 * @return
	 * n^3 
	 * 
	 */
	public int lengthOfLongestSubstring4(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++)
				if (allUnique(s, i, j))
					ans = Math.max(ans, j - i);
		return ans;
	}

	public boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;
	}

	@Test
	public void test() {
		String s = "aabcbad";
		System.out.println(lengthOfLongestSubstring3(s));
	}
}
