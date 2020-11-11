package Anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author mac
 * 
 *         Given an array of strings strs, group the anagrams together. You can
 *         return the answer in any order.
 * 
 *         An Anagram is a word or phrase formed by rearranging the letters of a
 *         different word or phrase, typically using all the original letters
 *         exactly once.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
 *         [["bat"],["nat","tan"],["ate","eat","tea"]] Example 2:
 * 
 *         Input: strs = [""] Output: [[""]] Example 3:
 * 
 *         Input: strs = ["a"] Output: [["a"]]
 */
public class GroupAnagram49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> ans = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String key = String.valueOf(ca);
			if (!ans.containsKey(key))
				ans.put(key, new ArrayList<>());
			ans.get(key).add(s);
		}
		return new ArrayList<List<String>>(ans.values());
	}

	public List<List<String>> groupAnagrams1(String[] strs) {
		if (strs.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> ans = new HashMap<String, List<String>>();
		int[] count = new int[26];
		for (String s : strs) {
			Arrays.fill(count, 0);
			for (char c : s.toCharArray())
				count[c - 'a']++;

			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();
			if (!ans.containsKey(key))
				ans.put(key, new ArrayList<String>());
			ans.get(key).add(s);
		}
		return new ArrayList<List<String>>(ans.values());
	}

	@Test
	public void test() {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams2(strs));
	}

	public List<List<String>> groupAnagrams2(String[] strs) {
		if (strs.length == 0)
			return new ArrayList<>();
		boolean[] bool = new boolean[strs.length];
		List<List<String>> res = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			if (bool[i])
				continue;
			List<String> temp = new ArrayList<String>();
			temp.add(strs[i]);
			for (int j = i + 1; j < bool.length; j++) {
				if (isAnagram(strs[j], strs[i])) {
					temp.add(strs[j]);
					bool[j] = true;
				}
			}
			res.add(temp);
		}
		return res;
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
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

	public List<List<String>> groupAnagrams3(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] ca = new char[26];
			for (char c : s.toCharArray())
				ca[c - 'a']++;
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<>());
			map.get(keyStr).add(s);
		}
		return new ArrayList<>(map.values());
	}

}
