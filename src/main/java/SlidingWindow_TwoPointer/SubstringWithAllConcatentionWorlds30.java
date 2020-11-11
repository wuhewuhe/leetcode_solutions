package SlidingWindow_TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author mac You are given a string s and an array of strings words of the
 *         same length. Return all starting indices of substring(s) in s that is
 *         a concatenation of each word in words exactly once, in any order, and
 *         without any intervening characters.
 * 
 *         You can return the answer in any order.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
 *         Explanation: Substrings starting at index 0 and 9 are "barfoo" and
 *         "foobar" respectively. The output order does not matter, returning
 *         [9,0] is fine too. Example 2:
 * 
 *         Input: s = "wordgoodgoodgoodbestword", words =
 *         ["word","good","best","word"] Output: [] Example 3:
 * 
 *         Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 *         Output: [6,9,12]
 * 
 * 
 *         Constraints:
 * 
 *         1 <= s.length <= 104 s consists of lower-case English letters. 1 <=
 *         words.length <= 5000 1 <= words[i].length <= 30 words[i] consists of
 *         lower-case English letters.
 */
public class SubstringWithAllConcatentionWorlds30 {
	/**
	 * @param s
	 * @param words
	 * @return
	 * 
	 *         two pointer time complex O(n) Space Complex O(1)
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		if (words == null || words.length == 0 || s == null || s.length() == 0)
			return new ArrayList<>();
		int[] map = new int[26];
		int count = 0;
		for (String str : words) {
			for (char c : str.toCharArray()) {
				map[c - 'a']++;
				count++;
			}
		}
		if (count > s.length())
			return new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		int[] copy = new int[26];
		int fast = 0, slow = 0, record = 0;
		while (fast < s.length()) {
			char c = s.charAt(fast);
			copy[c - 'a']++;
			record++;
			fast++;
			if (count == record) {
				if (Arrays.equals(map, copy))
					res.add(slow);
				copy[s.charAt(slow) - 'a']--;
				record--;
				slow++;
			}
		}
		return res;
	}

	/**
	 * @param s
	 * @param words
	 * @return
	 * 
	 *         two hashmap,one is record the initial words array, second is to loop
	 *         word in string
	 * 
	 *         time complex : O(n + m*k) space omplex : O(n)
	 */
	public List<Integer> findSubstring1(String s, String[] words) {
		if (words == null || words.length == 0 || s == null || s.length() == 0)
			return new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (String str : words)
			map.put(str, map.getOrDefault(str, 0) + 1);
		int n = words.length, m = words[0].length();
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i <= s.length() - n * m; i++) {
			Map<String, Integer> copy = new HashMap<>(map);
			int k = n, j = i;
			while (k > 0) {
				String str = s.substring(j, j + m);
				if (!copy.containsKey(str) || copy.get(str) < 1)
					break;
				copy.put(str, copy.get(str) - 1);
				k--;
				j += m;
			}
			if (k == 0)
				res.add(i);
		}
		return res;
	}

	@Test
	public void test() {
		String s = "barfoofoobarthefoobarman";
		String[] words = { "bar", "foo", "the" };
		System.out.println(findSubstring1(s, words));
	}
}
