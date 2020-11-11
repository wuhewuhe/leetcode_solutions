package Reverse;

import org.junit.Test;

/**
 * @author mac Given a string and an integer k, you need to reverse the first k
 *         characters for every 2k characters counting from the start of the
 *         string. If there are less than k characters left, reverse all of
 *         them. If there are less than 2k but greater than or equal to k
 *         characters, then reverse the first k characters and left the other as
 *         original. Example: Input: s = "abcdefg", k = 2 Output: "bacdfeg"
 *         Restrictions: The string consists of lower English letters only.
 *         Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII541 {
	/**
	 * @param s
	 * @param k
	 * @return
	 * 
	 *         solution : stringbuilder : construct a new string
	 * 
	 *         1 if less than k character, reverse all 2 more than K and less or
	 *         equal than 2 k, reverse first k
	 */
	public String reverseStr(String s, int k) {
		if (s == null || s.length() == 0)
			return "";
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (i < s.length()) {
			StringBuilder temp = new StringBuilder();
			if (i + k > s.length()) {
				temp.append(s.substring(i, s.length()));
				sb.append(temp.reverse());
				break;
			}
			int start = i;
			int end = i + 2 * k <= s.length() ? i + 2 * k : s.length();
			sb.append(temp.append(s.substring(start, start + k)).reverse() + s.substring(start + k, end));
			i = end;
		}
		return sb.toString();
	}

	/**
	 * @param s
	 * @param k
	 * @return
	 * 
	 *         char array swap character in different position
	 */
	public String reverseStr1(String s, int k) {
		char[] a = s.toCharArray();
		for (int start = 0; start < a.length; start += 2 * k) {
			int i = start, j = Math.min(start + k - 1, a.length - 1);
			while (i < j) {
				char tmp = a[i];
				a[i++] = a[j];
				a[j--] = tmp;
			}
		}
		return new String(a);
	}

	@Test
	public void test() {
		String s = "abcdefg";
		int k = 2;
		System.out.println(reverseStr(s, k));
	}
}
