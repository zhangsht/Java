package algorithm;

public class FindIntersection {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
		ListNode aListNode = headA;
		ListNode bListNode = headB;
		while (aListNode != bListNode) {
			aListNode = (aListNode == null) ? headB : aListNode.next;
			bListNode = (bListNode == null) ? headA : bListNode.next;
		}
		return aListNode;
	}
}
