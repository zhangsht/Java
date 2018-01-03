package leetcode;

public class SameTree {
	// check if they are the same or not.
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (q == null && p == null) {
			return true;
		}
		
		if ((q == null && p != null) || (q != null && p == null)) {
			return false;
		}
		
		if (p.val != q.val) {
			return false;
		}
		
		if (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)) {
			return false;
		}
		
		return true;
	}
}
