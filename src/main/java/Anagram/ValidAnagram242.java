package Anagram;

/**
 * @author mac Given two strings s and t , write a function to determine if t is
 *         an anagram of s.
 * 
 *         Example 1:
 * 
 *         Input: s = "anagram", t = "nagaram" Output: true Example 2:
 * 
 *         Input: s = "rat", t = "car" Output: false Note: You may assume the
 *         string contains only lowercase alphabets.
 * 
 *         Follow up: What if the inputs contain unicode characters? How would
 *         you adapt your solution to such case?
 */
public class ValidAnagram242 {
	public boolean isAnagram(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() != t.length())
			return false;
		int[] map = new int[128];
		for (char c : s.toCharArray())
			map[c]++;
		for (char c : t.toCharArray())
			map[c]--;
		for (int i : map) {
			if (i != 0)
				return false;
		}
		return true;
	}
}
