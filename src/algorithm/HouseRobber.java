package algorithm;

public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null) {
			return 0;
		}
		
		int rob = 0;
		int notRob = 0;
		for (int a : nums) {
			int cur = notRob + a;
			notRob = Math.max(notRob, rob);
			rob = cur;
		}
		
		return Math.max(rob, notRob);
	}
	
	public static void main(String[] args) {
		int [] a = new int[1];
		System.out.println(a[0]);
	}
}
