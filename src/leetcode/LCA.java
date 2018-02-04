package leetcode;

public class LCA {
	/*
	 * find the lowest common ancestor (LCA) of two given nodes in the BST.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		// make use of characteristic of BST
		while ((root.val - p.val) * (root.val - q.val) > 0) {
			root = p.val < root.val ? root.left : root.right;
		}
		
		return root;
	}
}
