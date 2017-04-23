package algorithm;

public class LengthOfLastWorld {
	public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        
        String [] words = s.split("\\s+");
        
        return words.length == 0 ? 0 : words[words.length - 1].length();
    }
	
	public int countSegments(String s) {
		if (s == null) {
			return 0;
		}
		
		s = s.trim();
		int len = s.length();
		if (len == 0) {
			return 0;
		}
		String [] words = s.split("\\s+");
		return words.length;
	}

	public static void main(String[] args) {
		String s = "Hello, my name is John";
		LengthOfLastWorld test = new LengthOfLastWorld();
		System.out.println(test.countSegments(s));
	}
}
