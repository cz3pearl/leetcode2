
public class RemoveDuplicateFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode nHead = null;
        ListNode nTail = null;
        if(null == head){
            return head;
        } else {
            nHead = new ListNode(head.val);
            nTail = nHead;
        }
        
        ListNode curr = head;
        while(null != curr){
            if(curr.val != nTail.val){
                nTail.next = new ListNode(curr.val);
                nTail = nTail.next;
            }
            curr = curr.next;
        }
        return nHead;
    }
}
