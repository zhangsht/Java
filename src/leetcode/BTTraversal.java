package leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BTTraversal {
	/*
	 * return the bottom-up level order traversal of its nodes' values from left to
	 * right, level by level from leaf to root
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> traversals = new LinkedList<>();
		if (root != null) {
			getResult(traversals, root, 1);
			Collections.reverse(traversals);
		}
		return traversals;
	}

	private void getResult(List<List<Integer>> traversals, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		
		if (traversals.size() < level) {
			List<Integer> tmp = new LinkedList<>();
			tmp.add(root.val);
			traversals.add(tmp);
		} else {
			traversals.get(level - 1).add(root.val);
		}
		getResult(traversals, root.left, level + 1);
		getResult(traversals, root.right, level + 1);
		return;
	}
}
