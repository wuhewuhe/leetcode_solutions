package SlidingWindow_TwoPointer;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author mac
 * 
 *         Given two strings s and t, return the minimum window in s which will
 *         contain all the characters in t. If there is no such window in s that
 *         covers all characters in t, return the empty string "".
 * 
 *         Note that If there is such a window, it is guaranteed that there will
 *         always be only one unique minimum window in s.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: s = "ADOBECODEBANC", t = "ABC" Output: "BANC" Example 2:
 * 
 *         Input: s = "a", t = "a" Output: "a"
 */
public class MinimumSlidingWindow76 {
	/**
	 * @param s
	 * @param t
	 * @return
	 * 
	 *         hashmap, two pointer one loop
	 */
	public String minWindow(String s, String t) {
		// corner case
		if (s == null || t == null || s.length() == 0 || t.length() == 0)
			return "";
		int slow = 0, count = 0, start = 0, len = Integer.MAX_VALUE;
		int[] map = new int[128];
		for (char c : t.toCharArray()) {
			map[c]++;
			count++;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map[c]--;
			if (map[c] >= 0) {
				count--;
			}
			while (count == 0) {
				char lc = s.charAt(slow);
				map[lc]++;
				if (map[lc] > 0) {
					if (i + 1 - slow < len) {
						start = slow;
						len = i + 1 - slow;
					}
					count++;
				}
				slow++;
			}
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
	}

	/**
	 * @param s
	 * @param t
	 * @return
	 * 
	 *         hash map
	 */
	public String minWindow1(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0)
			return "";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int count = 0, left = 0, len = Integer.MAX_VALUE, start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					count++;
			}
			while (count == map.size()) {
				char lc = s.charAt(left);
				if (map.containsKey(lc)) {
					map.put(lc, map.get(lc) + 1);
					if (map.get(lc) > 0) {
						if (i - left + 1 < len) {
							start = left;
							len = i + 1 - left;
						}
						count--;
					}
				}
				left++;
			}
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
	}

	/**
	 * @param s
	 * @param t
	 * @return
	 * 
	 *         two hashmap
	 */
	public String minWindow2(String s, String t) {
		if( s == null | t == null || s.length() == 0 || t.length() == 0 )
            return "";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int require = map.size(), count = 0;
		Map<Character, Integer> res = new HashMap<Character, Integer>();
		int left = 0, len = Integer.MAX_VALUE, start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			res.put(c, res.getOrDefault(c, 0) + 1);
			if (map.containsKey(c) && map.get(c).intValue() == res.get(c).intValue())
				count++;
			while (count == require) {
				char lc = s.charAt(left);
				res.put(lc, res.get(lc) - 1);
				if (map.containsKey(lc) && res.get(lc).intValue() < map.get(lc).intValue()) {
					if (i + 1 - left < len) {
						start = left;
						len = i + 1 - left;
					}
					count--;
				}
				left++;
			}
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
	}

	@Test
	public void test() {
		String s = "ADOBECODEBANC", t = "ABC";
		System.out.println(minWindow(s, t));
	}

}
