package algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		
		int flag = 1;
		Queue<TreeNode> qList = new LinkedList<TreeNode>();
		if (qList.isEmpty()) {
			System.out.println("empty queue");
		}
		qList.add(root);
		while (!qList.isEmpty()) {
			List<Integer> row = new ArrayList<Integer>();
			for (TreeNode a : qList) {
				row.add(a.val);
			}
			
			if (flag == -1) {
				Collections.reverse(row);
			}
			result.add(row);
			
			int t_size = qList.size();
			for (int i = 0; i < t_size; i++) {
				TreeNode treeNode = qList.peek();
				if (treeNode.left != null) {
					qList.add(treeNode.left);
				}
				if (treeNode.right != null) {
					qList.add(treeNode.right);
				}
				qList.poll();
			}
			flag *= -1;
		}
		return result;
	}
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		
		t3.left = t4;
		t3.right = t5;
		
		ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
		List<List<Integer>> result = zigzagLevelOrder.zigzagLevelOrder(t1);
		System.out.println("result size is : " + result.size());
		for (List<Integer> rowIntegers : result) {
			for (Integer a : rowIntegers) {
				System.out.print(a);
				System.out.print(' ');
			}
			System.out.println();
		}
		
	}
}
