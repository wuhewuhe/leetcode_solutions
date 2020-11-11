package Pattern;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author mac
 * 
 *         Given two strings s and t, determine if they are isomorphic.
 * 
 *         Two strings are isomorphic if the characters in s can be replaced to
 *         get t.
 * 
 *         All occurrences of a character must be replaced with another
 *         character while preserving the order of characters. No two characters
 *         may map to the same character but a character may map to itself.
 * 
 *         Example 1:
 * 
 *         Input: s = "egg", t = "add" Output: true Example 2:
 * 
 *         Input: s = "foo", t = "bar" Output: false Example 3:
 * 
 *         Input: s = "paper", t = "title" Output: true Note: You may assume
 *         both s and t have the same length.
 */
public class IsomophicString205 {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			if (map.containsKey(cs)) {
				if (!map.get(cs).equals(ct))
					return false;
			} else {
				if (map.containsValue(ct))
					return false;
				map.put(cs, ct);
			}
		}
		return true;
	}


	@Test
	public void test() {
		String s = "ac", t = "ce";
		System.out.println(isIsomorphic(s, t));
	}
}
