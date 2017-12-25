package leetcode;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void nextPermutation(int[] nums) {
		if (nums == null) {
			return;
		}
		int n = nums.length;
		if (n < 2) {
			return;
		}
		
		// get highest position
		int index = n - 1;
		while (index > 0) {
			if (nums[index - 1] < nums[index]) {
				break;
			}
			index--;
		}
		
		// largest permutation
		if (index == 0) {
			reverse(nums, 0, n - 1);
			return;
		}
		
		// swap smallest position, then reverse
		int j = n - 1;
		while (index <= j) {
			if (nums[index - 1] < nums[j]) {
				break;
			}
			j--;
		}
		swap(nums, index - 1, j);
		reverse(nums, index, n - 1);
		return;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		return;
	}

	// reverse to get smallest permutation of [i, j]
	private void reverse(int[] nums, int i, int j) {
		if (i >= j) {
			return;
		}
		
		for (int k = i, mid = (i + j) / 2; k <= mid; k++) {
			swap(nums, k, i + j - k);
		}
	}
}
