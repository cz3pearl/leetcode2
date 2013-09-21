
public class SwapNodesInPairs {
	
    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);       
     }
 	
     public ListNode reverseKGroup(ListNode head, int k) {
         ListNode tmpHead = new ListNode(1);
         tmpHead.next = head;
         ListNode lastTail = tmpHead;
         ListNode tail = findNextK(head, k);
         ListNode tailNext = null;
         while(null != tail){
         	tailNext = tail.next;
         	tailNext = tail.next;
         	doReverse(head, tail);
         	lastTail.next = tail;
         	lastTail = head;
         	head = tailNext;
         	tail = findNextK(head, k);
         }
         return tmpHead.next;
     }
     
     private void doReverse(ListNode head, ListNode tail){
     	if(null != head && null != tail && head != tail){
     		ListNode tailNext = tail.next;
     		ListNode next = head.next;
     		ListNode tTail = head;
     		tTail.next = null;
     		while(next != tail){
     			ListNode tNext = next.next;
     			next.next = tTail;
     			tTail = next;
     			next = tNext;
     		}
     		tail.next = tTail;    		
     		head.next = tailNext;
     	}
     }
     
     private ListNode findNextK(ListNode node, int k){
     	ListNode next = node;
     	while(--k > 0 && null != next){
     		next = next.next;
     	}
     	return next;
     }

}
