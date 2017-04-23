package algorithm;

public class HammingWeight {
	public int hammingWeight(int n) {
		int count = 0;
		int i = 0;
		while (i++ < 32) {
			if ((1 & (n >> i)) == 1) {
				count++;
				//System.out.println(count);
			}
		}
		return count;
	}
	
	public int hammingDistance(int x, int y) {
		int count = 0;
		int i = 0;
		while (i < 32) {
			int a = (1 & (x >> i));
			int b = (1 & (y >> i));
			//System.out.println("x: " + a + "y: " + b);
			if ((a ^ b) == 1) {
				count++;
				//System.out.println("count " + count);
			}
			
			i++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		HammingWeight hammingWeight = new HammingWeight();
		System.out.println(hammingWeight.hammingDistance(1, 4));
	}
}
