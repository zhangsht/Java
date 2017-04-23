package algorithm;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionOfArray {
	/*public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> setOfOne = new HashSet<>();
		Set<Integer> setOfAll = new HashSet<>();
		for (int a : nums1) {
			setOfOne.add(a);
		}
		
		for (int b : nums2) {
			if (setOfOne.contains(b)) {
				setOfAll.add(b);
			}
		}
		
		int[] intersection = new int[setOfAll.size()];
		int i = 0;
		for (Integer num : setOfAll) {
			intersection[i++] = num;
		}
		return intersection;
	}*/
	
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> mapOfOne = new HashMap<>();
		for (int a : nums1) {
			if (mapOfOne.containsKey(a)) {
				mapOfOne.put(a, mapOfOne.get(a) + 1);
			} else {
				mapOfOne.put(a, 1);
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		for (int b : nums2) {
			if (mapOfOne.containsKey(b) && mapOfOne.get(b) > 0) {
				result.add(b);
				mapOfOne.put(b, mapOfOne.get(b) - 1);
			}
		}
		
		int[] intersection = new int[result.size()];
		int i = 0;
		for (Integer num : result) {
			intersection[i++] = num;
		}
		return intersection;
	}
	
	public static void main(String[] args) {
		IntersectionOfArray intersection = new IntersectionOfArray();
		int[] num1 = {1, 2, 1, 2};
		int[] num2 = {2, 2};
		int[] result = intersection.intersect(num1, num2);
		for (int a : result) {
			System.out.println(a);
		}
	}
}
