package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import javax.xml.bind.ValidationEvent;

public class MergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,
				new Comparator<ListNode>() {
					@Override
					public int compare(ListNode o1, ListNode o2) {
						if (o1.val < o2.val) {
							return -1;
						} else if (o1.val == o2.val) {
							return 0;
						} else {
							return 1;
						}
					}
		});
		
		ListNode dummyListNode = new ListNode(0);
		ListNode taiListNode = dummyListNode;
		
		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}
		
		while (!queue.isEmpty()) {
			taiListNode.next = queue.poll();
			taiListNode = taiListNode.next;
			
			if (taiListNode.next != null) {
				queue.add(taiListNode.next);
			}
		}
		
		return dummyListNode.next;
		
	}

}
