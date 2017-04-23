package algorithm;

import java.awt.List;

public class ReverseList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode pre = head, cur = head.next;
		head.next = null;
		while (cur != null) {
			ListNode tem = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tem;
		}
		return pre;
	}
	
	public static void main(String[] args) {
		ReverseList reverseList = new ReverseList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		ListNode head = reverseList.reverseList(l1);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
