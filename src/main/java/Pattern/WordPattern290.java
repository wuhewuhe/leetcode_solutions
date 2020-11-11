package Pattern;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author mac Given a pattern and a string s, find if s follows the same
 *         pattern.
 * 
 *         Here follow means a full match, such that there is a bijection
 *         between a letter in pattern and a non-empty word in s.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: pattern = "abba", s = "dog cat cat dog" Output: true Example
 *         2:
 * 
 *         Input: pattern = "abba", s = "dog cat cat fish" Output: false Example
 *         3:
 * 
 *         Input: pattern = "aaaa", s = "dog cat cat dog" Output: false Example
 *         4:
 * 
 *         Input: pattern = "abba", s = "dog dog dog dog" Output: false
 * 
 * 
 *         Constraints:
 * 
 *         1 <= pattern.length <= 300 pattern contains only lower-case English
 *         letters. 1 <= s.length <= 3000 s contains only lower-case English
 *         letters and spaces ' '. s does not contain any leading or trailing
 *         spaces. All the words in s are separated by a single space.
 */
public class WordPattern290 {
	/**
	 * @param pattern
	 * @param s
	 * @return
	 * 
	 * 
	 *         map : index
	 */
	public boolean wordPattern(String pattern, String s) {
		Map<Object, Integer> map_index = new HashMap<>();
		String[] words = s.split(" ");

		if (words.length != pattern.length())
			return false;

		for (Integer i = 0; i < words.length; i++) {
			char c = pattern.charAt(i);
			String w = words[i];

			if (!map_index.containsKey(c))
				map_index.put(c, i);

			if (!map_index.containsKey(w))
				map_index.put(w, i);

			if (map_index.get(c) != map_index.get(w))
				return false;
		}

		return true;
	}

	/**
	 * @param pattern
	 * @param s
	 * @return map : character and string
	 */
	public boolean wordPattern1(String pattern, String s) {
		if (s == null || pattern == null)
			return false;
		String[] strs = s.split(" ");
		if (strs.length != pattern.length())
			return false;
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char c = pattern.charAt(i);
			String str = strs[i];
			if (map.containsKey(c)) {
				if (!map.get(c).equals(str))
					return false;
			} else {
				if (map.containsValue(strs[i]))
					return false;
				map.put(c, str);
			}
		}
		return true;
	}

	@Test
	public void test() {
		String pattern = "abba", s = "dog cat dog dog";
		System.out.println(wordPattern(pattern, s));
	}
}
