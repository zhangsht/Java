package algorithm;

public class ListCycle {
	/*public ListNode detectCycle(ListNode head) {
		
	}*/

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		
		ListNode slow = head;
		ListNode fast = head.next;
		while (true) {
			slow = slow.next;
			
			fast = fast.next;
			if (fast == null) {
				return false;
			}
			if (fast == slow) {
				return true;
			}
			
			fast = fast.next;
			if (fast == null) {
				return false;
			}
			if (fast == slow) {
				return true;
			}
		}
	}
}
