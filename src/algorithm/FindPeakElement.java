package algorithm;

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left != right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[mid + 1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		
		FindPeakElement peakElement = new FindPeakElement();
		int[] nums = {10, 4, 2, 0};
		System.out.println(peakElement.findPeakElement(nums));
	}
}
