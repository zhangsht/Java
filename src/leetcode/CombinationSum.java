package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum combinationSum = new CombinationSum();
		int candidates[] = { 10, 1, 2, 7, 6, 8, 1, 5 };
		int target = 8;
		List<List<Integer>> list = combinationSum.combinationSum2(candidates, target);
		for (List<Integer> row : list) {
			for (int a : row) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		System.out.println("done");
	}

	// number may be used more than one
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null) {
			return null;
		}
		Arrays.sort(candidates);
		List<List<Integer>> list = new ArrayList<>();
		getResult(candidates, target, 0, list, new ArrayList<>());
		return list;
	}

	private void getResult(int[] candidates, int target, int start, List<List<Integer>> list, ArrayList<Integer> cur) {
		if (target == 0) {
			// add a new list
			list.add(new ArrayList<>(cur));
		} else if (target > 0) {
			for (int i = start; i < candidates.length; i++) {
				// backtracking
				cur.add(candidates[i]);
				// next index remains i
				getResult(candidates, target - candidates[i], i, list, cur);
				cur.remove(cur.size() - 1);
			}
		}
		return;
	}

	// number is only used once
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates == null) {
			return null;
		}
		Arrays.sort(candidates);
		List<List<Integer>> list = new ArrayList<>();
		getResult2(candidates, target, 0, list, new ArrayList<Integer>());
		return list;
	}

	private void getResult2(int[] candidates, int target, int start, List<List<Integer>> list, ArrayList<Integer> cur) {
		if (target < 0 || start >= candidates.length) {
			return;
		}
		if (target == 0) {
			// add a new list
			list.add(new ArrayList<>(cur));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			// backtracking
			cur.add(candidates[i]);
			// next index need adding 1
			getResult2(candidates, target - candidates[i], i + 1, list, cur);
			cur.remove(cur.size() - 1);
		}
	}
}
