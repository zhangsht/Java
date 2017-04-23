package algorithm;

public class MedianOfSortedTwoArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, 
        	n = nums2.length;
        int l = (m + n + 1) / 2,
        	r = (m + n + 2) / 2;
        
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }
    
    
    private double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
		if (start1 >= nums1.length) {
			return nums2[start2 + k - 1];
		}
		if (start2 >= nums2.length) {
			return nums1[start1 + k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}
		
		int mid1 = Integer.MAX_VALUE,
			mid2 = Integer.MAX_VALUE;
		if (start1 + k / 2 - 1 < nums1.length) {
			mid1 = nums1[start1 + k / 2 - 1];
		}
		
		if (start2 + k / 2 - 1 < nums2.length) {
			mid2 = nums2[start2 + k / 2 - 1];
		}
		
		if (mid1 < mid2) {
			return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
		} else {
			return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
		}
	}
}
