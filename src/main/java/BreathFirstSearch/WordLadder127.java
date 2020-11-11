package BreathFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author mac Given two words (beginWord and endWord), and a dictionary's word
 *         list, find the length of shortest transformation sequence from
 *         beginWord to endWord, such that:
 * 
 *         Only one letter can be changed at a time. Each transformed word must
 *         exist in the word list. Note:
 * 
 *         Return 0 if there is no such transformation sequence. All words have
 *         the same length. All words contain only lowercase alphabetic
 *         characters. You may assume no duplicates in the word list. You may
 *         assume beginWord and endWord are non-empty and are not the same.
 *         Example 1:
 * 
 *         Input: beginWord = "hit", endWord = "cog", wordList =
 *         ["hot","dot","dog","lot","log","cog"]
 * 
 *         Output: 5
 * 
 *         Explanation: As one shortest transformation is "hit" -> "hot" ->
 *         "dot" -> "dog" -> "cog", return its length 5. Example 2:
 * 
 *         Input: beginWord = "hit" endWord = "cog" wordList =
 *         ["hot","dot","dog","lot","log"]
 * 
 *         Output: 0
 * 
 *         Explanation: The endWord "cog" is not in wordList, therefore no
 *         possible transformation.
 */
public class WordLadder127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList);
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		// COUNT NUMBER OF WORDS TRANSFORMED
		int count = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			// FOR ALL WORDS THIS ROUND
			for (int i = 0; i < size; i++) {
				char[] current = queue.poll().toCharArray();
				// TRAVERSE CURRENT WORD
				for (int j = 0; j < current.length; j++) {
					char tmp = current[j];
					// CHANGE ONE LETTER AT A TIME
					for (char c = 'a'; c <= 'z'; c++) {
						current[j] = c;
						String next = new String(current);
						// WHEN NEXT WORD IS IN THE SET
						if (set.contains(next)) {
							if (next.equals(endWord))
								return count + 1;
							queue.add(next);
							set.remove(next);
						}
					}
					// HAVE TO UNDO FOR NEXT CHANGE OF LETTER
					current[j] = tmp;
				}
			}
			// THIS ROUND ENDS WITH ONE LETTER CHANGED
			count++;
		}
		return 0;
	}
}
