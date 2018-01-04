package leetcode;

import java.util.LinkedList;
import java.util.List;

public class TreePaths {
	// all root-to-leaf paths.
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new LinkedList<>();
		if (root != null) {
			getResult(paths, root, new StringBuilder());
		}
		
		return paths;
	}

	private void getResult(List<String> paths, TreeNode root, StringBuilder cur) {
		cur.append(Integer.toString(root.val));
		if (root.left == null && root.right == null) {
			paths.add(cur.toString());
			return;
		}
		cur.append('-');
		cur.append('>');
		if (root.left != null) {
			getResult(paths, root.left, new StringBuilder(cur));
		}
		if (root.right != null) {
			getResult(paths, root.right, new StringBuilder(cur));
		}
		
		return;
	}
}
