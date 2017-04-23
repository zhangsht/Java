package algorithm;

public class KthSamllInLexi {
	
	public int findKthNumber(int n, int k) {
		k--;
		int cur = 1;
		while (k > 0) {
			int steps = caculateSteps(n, cur, cur + 1);
			if (steps <= k) {
				k -= steps;
				cur++;
			} else {
				k--;
				cur *= 10;
			}
		}
		return cur;
	}
	
	private int caculateSteps(int n, long cur, long next) {
		int steps = 0;
		while (cur <= n) {
			steps += Math.min(n + 1, next) - cur;
			cur *= 10;
			next *= 10;
		}
		return steps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
