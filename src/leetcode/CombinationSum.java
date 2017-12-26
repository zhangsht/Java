package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
				getResult(candidates, target - candidates[i], i, list, cur);
				cur.remove(cur.size() - 1);
			}
		}
		return;
	}

}
