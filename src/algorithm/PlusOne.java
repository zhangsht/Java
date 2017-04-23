package algorithm;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.text.AbstractDocument.LeafElement;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        ArrayList<Integer> number = new ArrayList<Integer>();
        int a = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
        	int b = digits[i] + a;
        	a = b / 10;
        	b = b % 10;
        	number.add(b);
        }
        if (a != 0) {
        	number.add(a);
        }
        Collections.reverse(number);
        int [] result = new int[number.size()];
        for (int i = 0; i < number.size(); i++) {
        	result[i] = number.get(i);
        }
        return result;
    }
	
	public String addBinary(String a, String b) {
		if (a == null && b == null) {
			return new String("");
		}
		
		if (a == null || a.length() == 0) {
			return b;
		}
		
		if (b == null || b.length() == 0) {
			return a;
		}
		
		int aLen = a.length() - 1,
			bLen = b.length() - 1;
		ArrayList<Character> sum = new ArrayList<>();
		int c = 0;
		for (; aLen >= 0 || bLen >= 0; aLen--, bLen--) {
			int opr1 = aLen < 0 ? 0 : a.charAt(aLen) - '0';
			
			int	opr2 = bLen < 0 ? 0 : b.charAt(bLen) - '0';
			
			int s = opr1 ^ opr2 ^ c;
			sum.add((char) (s + '0'));
			c = (opr1 & opr2) | (c & (opr1 | opr2));
			//System.out.println(c);
		}
		if (c != 0) {
			sum.add((char) (c + '0'));
		}
		
		int len = sum.size();
		char [] result = new char[len];
		for (int i = 0; i < len; i++) {
			result[i] = sum.get(len - i - 1);
		}
		return new String(result);
	}
	
	public static void main(String[] args) {
		PlusOne plusOne = new PlusOne();
		
		String a = "1", b = "0";
		System.out.println(plusOne.addBinary(a, b));
	}
}
