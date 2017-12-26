package leetcode;

public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode newHead = head.next;
		// recursion but o(n) space
		head.next = swapPairs(head.next.next);
		newHead.next = head;
		return newHead;
	}
	
	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		// constant space
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode left = head;
		ListNode right = head.next;
		ListNode prev = dummy;
		while (right != null) {
			left.next = right.next;
			right.next = left;
			prev.next = right;
			prev = left;
			left = prev.next;
			if (left != null) {
				right = left.next;
			} else {
				break;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		SwapPairs swapPairs = new SwapPairs();
		ListNode head = new ListNode(0);
		ListNode next = new ListNode(1);
		head.next = next;
		head = swapPairs.swapPairs2(head);
		System.out.println(head.val);
	}
}
