
public class ReverseLinkList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode p = head;
    	ListNode pP = null; 
    	for(int i = 1; i < m; i++){
    		pP = p;
    		p = p.next;
    	}
    	ListNode reversedList = reverseTopN(p, n-m+1);
    	if(null != pP){
    		pP.next = reversedList;
    		return head;
    	} else {
    		return reversedList;
    	}
    }
    
    public ListNode reverseTopN(ListNode head, int n){
    	if(null != head){
    		
    		ListNode curr = head;
	    	ListNode onext = head.next;
	    	ListNode cnext = null;
	    	int count = n;
	    	while(null != onext && --count > 0){
	    		curr.next = cnext;
	    		cnext = curr;
	    		//For next iteration
	    		curr = onext;
	    		onext = onext.next;
	    	}
	    	curr.next = cnext;
	    	head.next = onext;
	    	return curr;
    	} else {
    		return null;
    	}
    }
    
    public static void main(String args[]){
    	ListNode head = new ListNode(-1);
    	ListNode tail = new ListNode(-3);
    	head.next = tail;
    	ReverseLinkList2 rll2 = new ReverseLinkList2();
    	head = rll2.reverseBetween(head, 1, 2);
    	ListNode curr = head;
    	while(null != curr){
    		System.out.println(curr.val);
    		curr = curr.next;
    	}
    }

}
