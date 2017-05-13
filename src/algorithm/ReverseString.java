package algorithm;

import java.util.HashSet;
import java.util.Set;

public class ReverseString {
	public String reverseString(String s) {
		StringBuilder str = new StringBuilder(s);
		return str.reverse().toString();
	}
	
	public String reverseStr(String s, int k) {
		if (s == null || k <= 0 || s.length() <= 1)
			return s;
        char [] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
        	for (int j = i, t = Math.min(s.length() - 1, i + k - 1);j < t; j++, t--) {
        		char tem = arr[j];
        		arr[j] = arr[t];
        		arr[t] = tem;
        	}
        }
        return new String(arr);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseString reverseString = new ReverseString();
		System.out.println(reverseString.reverseStr("abcdefg", 2));
	}
	
	public String reverseVowels(String s) {
		char[] str = s.toCharArray();
		Set<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		for (int i = 0, j = str.length - 1; i < j;) {
			if (!set.contains(str[i])) {
				i++;
				continue;
			}
			
			if (!set.contains(str[j])) {
				j--;
				continue;
			}
			
			char t = str[i];
			str[i] = str[j];
			str[j] = t;
			i++;
			j--;
		}
		
		return String.valueOf(str);
	}

	public boolean isIsomorphic(String s, String t) {
		int[] m1 = new int[256];
		int[] m2 = new int[256];
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
				return false;
			}
			
			m1[s.charAt(i)] = i + 1;
			m2[t.charAt(i)] = i + 1;
		}
		return true;
	}
}
