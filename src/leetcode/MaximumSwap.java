package leetcode;

public class MaximumSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSwap test = new MaximumSwap();
		System.out.println(test.maximumSwap(236));
	}

	/*
	 * digits 从左到右扫描 查找比当前数值大的数
	 * buckets 从右向左 保证找的数为最大
	 * 时间复杂度 o(1)
	 */
	public int maximumSwap(int num) {
		char[] digits = Integer.toString(num).toCharArray();
		int[] bukets = new int[10]; 
		// 记录最后索引
		for (int i = 0; i < digits.length; i++) {
			bukets[digits[i] - '0'] = i;
		}
		
		for (int i = 0; i < digits.length; i++) {
			// 检查是否存在替换的可能
			for (int j = 9; j > digits[i] - '0'; j--) {
				if (bukets[j] > i) {
					swap(digits, i, bukets[j]);
					return Integer.valueOf(new String(digits));
				}
			}
		}
		
		// 当前数值即为最大
		return num;
	}

	private void swap(char[] digits, int i, int j) {
		char tmp = digits[i];
		digits[i] = digits[j];
		digits[j] = tmp;
	}

}
