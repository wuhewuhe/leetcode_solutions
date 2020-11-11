package SlidingWindow_TwoPointer;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author mac
 *
 *
 *         Given two strings s1 and s2, write a function to return true if s2
 *         contains the permutation of s1. In other words, one of the first
 *         string's permutations is the substring of the second string.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: s1 = "ab" s2 = "eidbaooo" Output: True Explanation: s2
 *         contains one permutation of s1 ("ba"). Example 2:
 * 
 *         Input:s1= "ab" s2 = "eidboaoo" Output: False
 */
public class PermutationInString567 {
	public boolean checkInclusion(String s1, String s2) {
		s1 = sort(s1);
		for (int i = 0; i <= s2.length() - s1.length(); i++) {
			if (s1.equals(sort(s2.substring(i, i + s1.length()))))
				return true;
		}
		return false;
	}

	public String sort(String s) {
		char[] t = s.toCharArray();
		Arrays.sort(t);
		return new String(t);
	}

	public boolean checkInclusion1(String s1, String s2) {
		int[] map = new int[26];
		int count = 0;
		for (char c : s1.toCharArray()) {
			map[c - 'a']++;
			count++;
		}
		int left = 0;
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			map[c - 'a']--;
			count--;
			if (count == 0) {
				if (allzero(map))
					return true;
				char lc = s2.charAt(left);
				map[lc - 'a']++;
				count++;
				left++;
			}
		}
		return false;
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
		String s1 = "abc", s2 = "dacb";
		System.out.println(checkInclusion1(s1, s2));
	}
}
