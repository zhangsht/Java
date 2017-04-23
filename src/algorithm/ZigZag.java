package algorithm;

public class ZigZag {
	public String convert(String s, int numRows) {
		StringBuffer[]  sb = new StringBuffer[numRows];
		for (int i = 0; i < numRows; i++) {
			sb[i] = new StringBuffer();
		}
		
		char[] c = s.toCharArray();
		int len = s.length();
		int i = 0;
		while (i < len) {
			for (int idx = 0; idx < numRows && i < len; idx++) {
				sb[idx].append(c[i]);
				i++;
			}
			
			for (int idx = numRows - 2; idx > 0 && i < len; idx--) {
				sb[idx].append(c[i]);
				i++;
			}
		}
		
		for (int idx = 1; idx < numRows; idx++) {
			sb[0].append(sb[idx].toString());
		}
		
		return sb[0].toString();
	}
	
	public static void main(String[] args) {
		ZigZag zag = new ZigZag();
		String string = "PAYPALISHIRING";
		int numRows = 3;
		System.out.println(zag.convert(string, 3));
	}
}
