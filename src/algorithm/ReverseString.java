package algorithm;

public class ReverseString {
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

}
