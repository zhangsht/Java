package algorithm;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
	public int firstUniqChar(String s) {
		if (s == null || s.length() <= 0) {
			return -1;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int i;
		for (i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				break;
			}
		}
		
		return i == s.length() ? -1 : i;
	}
	
	public static void main(String[] args) {
		FirstUniqChar firstUniqChar = new FirstUniqChar();
		System.out.println(firstUniqChar.firstUniqChar("ll"));
	}
}
