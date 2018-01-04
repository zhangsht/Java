package leetcode;

public class PathSum {
	/*
	 * determine if the tree has a root-to-leaf path such that adding up all the
	 * values along the path equals the given sum.
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		boolean isHas = false;
		if (root != null) {
			isHas = getResult(root, sum);
		}
		return isHas;
	}

	private boolean getResult(TreeNode root, int sum) {
		if (root == null && sum == 0) {
			return true;
		}
		if (root == null && sum != 0) {
			return false;
		}
		if (root.right == null && root.left != null) {
			return getResult(root.left, sum - root.val);
		}
		if (root.right != null && root.left == null) {
			return getResult(root.right, sum - root.val);
		}
		
		return getResult(root.left, sum - root.val) || getResult(root.right, sum - root.val);
	}
}
