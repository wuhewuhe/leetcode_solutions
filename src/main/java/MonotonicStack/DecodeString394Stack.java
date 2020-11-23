package MonotonicStack;

import java.util.Stack;

import org.junit.Test;

/**
 * @author mac Given an encoded string, return its decoded string.
 * 
 *         The encoding rule is: k[encoded_string], where the encoded_string
 *         inside the square brackets is being repeated exactly k times. Note
 *         that k is guaranteed to be a positive integer.
 * 
 *         You may assume that the input string is always valid; No extra white
 *         spaces, square brackets are well-formed, etc.
 * 
 *         Furthermore, you may assume that the original data does not contain
 *         any digits and that digits are only for those repeat numbers, k. For
 *         example, there won't be input like 3a or 2[4].
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: s = "3[a]2[bc]" Output: "aaabcbc" Example 2:
 * 
 *         Input: s = "3[a2[c]]" Output: "accaccacc" Example 3:
 * 
 *         Input: s = "2[abc]3[cd]ef" Output: "abcabccdcdcdef" Example 4:
 * 
 *         Input: s = "abc3[cd]xyz" Output: "abccdcdcdxyz"
 */
public class DecodeString394Stack {
	/**
	 * @param s
	 * @return
	 * 
	 *         countStack: The stack would store all the integer k. stringStack: The
	 *         stack would store all the decoded strings.
	 */
	public String decodeString(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();
		StringBuilder currentString = new StringBuilder();
		int k = 0;
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				k = k * 10 + ch - '0';
			} else if (ch == '[') {
				// push the number k to countStack
				countStack.push(k);
				// push the currentString to stringStack
				stringStack.push(currentString);
				// reset currentString and k
				currentString = new StringBuilder();
				k = 0;
			} else if (ch == ']') {
				StringBuilder decodedString = stringStack.pop();
				// decode currentK[currentString] by appending currentString k times
				for (int currentK = countStack.pop(); currentK > 0; currentK--) {
					decodedString.append(currentString);
				}
				currentString = decodedString;
			} else {
				currentString.append(ch);
			}
		}
		return currentString.toString();
	}

	@Test
	public void test() {
		String s = "3[a2[c]]";
		System.out.println(decodeString(s));
	}
}
