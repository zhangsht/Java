package algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Base7 {
	public String convertToBase7(int num) {
		StringBuffer num_7 = new StringBuffer();
		boolean flag = false;
		if (num < 0) {
			num = -num;
			flag = true;
		}
		
		while (num != 0) {
			num_7.append((char) (num % 7 + '0'));
			num /= 7;
		}
		
		if (flag) {
			num_7.append('-');
		}
		return num_7.reverse().toString();
	}
	
	public static void main(String[] args) {
		Base7 base7 = new Base7();
		System.out.println(base7.convertToBase7(100));
	}
}
