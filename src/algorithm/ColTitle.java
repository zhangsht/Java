package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ColTitle {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		set.add(n);
		while (true) {
			int sum = 0;
			while (n != 0) {
				int a = n % 10;
				sum += (a * a);
				n /= 10;
			}
			
			if (sum == 1) {
				return true;
			}
			
			if (set.contains(sum)) {
				return false;
			} else {
				set.add(sum); 
			}
			
			n = sum;
		}
	}
	
    public int titleToNumber(String s) {
        int t = 0, d = 26;
        for (int i = 0, len = s.length(); i < len; i++) {
        	t= t * d + (int)s.charAt(i) - (int)'A' + 1;
        }
        
        return t;
    }

	public String convertToTitle(int n) {
		char[] characters = new char[26];
		for (int i = 1; i < 26; i++) {
			characters[i] = (char) ('A' + i - 1);
		}
		characters[0] = 'Z';

		ArrayList<Character> title = new ArrayList<>();
		while (n > 0) {
			title.add(characters[n % 26]);
			if (n % 26 == 0) {
				n--;
			}
			n /= 26;
		}
		int len = title.size();
		char[] ans = new char[len];
		for (int i = 0; i < len; i++) {
			ans[i] = title.get(len - i - 1);
		}

		return String.copyValueOf(ans);
	}

	public static void main(String[] args) {
		ColTitle colTitle = new ColTitle();
		// System.out.println(colTitle.convertToTitle(27));
		//System.out.println(colTitle.titleToNumber(new String("Z")));
		System.out.println(colTitle.isHappy(19));
	}
}
