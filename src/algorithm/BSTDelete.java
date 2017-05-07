package algorithm;

public class BSTDelete {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return null;
		if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else {
			if (root.left == null) return root.right;
			if (root.right == null) return root.left;
			
			TreeNode miNode = findMin(root.right);
			root.val = miNode.val;
			root.right = deleteNode(root.right, miNode.val);
		}
		return root;
	}
	
	private TreeNode findMin(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
}
