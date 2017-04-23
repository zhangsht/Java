package algorithm;

import java.math.BigInteger;

public class AdditiveNumber {
	
	public boolean isAdditiveNumber(String num) {
		int n = num.length();
		for (int i = 1; i <= n / 2; i++) {
			if (num.charAt(0) == '0' && i > 1) {
				return false;
			}
			
			BigInteger val1 = new BigInteger(num.substring(0, i));
			for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
				if (num.charAt(i) == '0' && j > 1) {
					break;
				}
				BigInteger val2 = new BigInteger(num.substring(i, i + j));
				if (isValid(val1, val2, i + j, num)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isValid(BigInteger v1, BigInteger v2, int start, String num) {
		if (start == num.length()) {
			return true;
		}
		
		v2 = v2.add(v1);
		v1 = v2.subtract(v1);
		return num.startsWith(v2.toString(), start) && isValid(v1, v2, start + v2.toString().length(), num);
	}
}
