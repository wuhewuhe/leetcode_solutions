package Anagram;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author mac Given a string s and a non-empty string p, find all the start
 *         indices of p's anagrams in s.
 * 
 *         Strings consists of lowercase English letters only and the length of
 *         both strings s and p will not be larger than 20,100.
 * 
 *         The order of output does not matter.
 * 
 *         Example 1:
 * 
 *         Input: s: "cbaebabacd" p: "abc"
 * 
 *         Output: [0, 6]
 * 
 *         Explanation: The substring with start index = 0 is "cba", which is an
 *         anagram of "abc". The substring with start index = 6 is "bac", which
 *         is an anagram of "abc". Example 2:
 * 
 *         Input: s: "abab" p: "ab"
 * 
 *         Output: [0, 1, 2]
 * 
 *         Explanation: The substring with start index = 0 is "ab", which is an
 *         anagram of "ab". The substring with start index = 1 is "ba", which is
 *         an anagram of "ab". The substring with start index = 2 is "ab", which
 *         is an anagram of "ab".
 */
public class FindAllAnagramInString438 {
	/**
	 * @param s
	 * @param p
	 * @return
	 * 
	 *         two tips : 1 p is no empty string; 2 only contains english letters
	 *         sliding window
	 */
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (s == null || s.length() < p.length())
			return res;
		int count = 0;
		int[] map = new int[26];
		for (char c : p.toCharArray()) {
			count++;
			map[c - 'a']++;
		}
		int left = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map[c - 'a']--;
			count--;
			if (count == 0) {
				if (allzero(map))
					res.add(left);
				char lc = s.charAt(left);
				map[lc - 'a']++;
				count++;
				left++;
			}
		}
		return res;
	}

	private boolean allzero(int[] map) {
		for (int i : map) {
			if (i != 0)
				return false;
		}
		return true;
	}

	@Test
	public void test() {
		String s = "cbaebabacd", p = "abc";
		System.out.println(findAnagrams(s, p));
	}
}
