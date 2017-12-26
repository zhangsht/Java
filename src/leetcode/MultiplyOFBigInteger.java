package leetcode;

public class MultiplyOFBigInteger {

	public static void main(String[] args) {
		MultiplyOFBigInteger multiplyOFBigInteger = new MultiplyOFBigInteger();
		String num1 = "12";
		String num2 = "12";
		String result = multiplyOFBigInteger.multiply(num1, num2);
		System.out.println(result);
	}
	
	public String multiply(String num1, String num2) {
		int m = num1.length();
		int n = num2.length();
		int [] pos = new int[m + n];
		
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				// index i, j -> index i+j, i+j+1
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + pos[i + j + 1];
				pos[i + j] += mul / 10;
				pos[i + j + 1] = mul % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int a : pos) {
			// in case of leading zero or all zero
			if (!(sb.length() == 0 && a == 0)) {
				sb.append(a);
			}
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}

}
