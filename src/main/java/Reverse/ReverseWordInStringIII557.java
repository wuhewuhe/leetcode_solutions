package Reverse;

import org.junit.Test;

/**
 * @author mac Given a string, you need to reverse the order of characters in
 *         each word within a sentence while still preserving whitespace and
 *         initial word order.
 * 
 *         Example 1: Input: "Let's take LeetCode contest" Output: "s'teL ekat
 *         edoCteeL tsetnoc" Note: In the string, each word is separated by
 *         single space and there will not be any extra space in the string.
 */
public class ReverseWordInStringIII557 {
	/**
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return "";
		String[] strs = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			StringBuilder temp = new StringBuilder();
			sb.append(temp.append(strs[i]).reverse() + " ");
		}
		// return sb.substring(0, sb.length() - 1).toString();
		return sb.toString().trim();
	}

	@Test
	public void test() {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}
}
