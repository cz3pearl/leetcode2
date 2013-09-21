
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode head = null;
    	ListNode curr = head;
    	ListNode t1 = l1;
    	ListNode t2 = l2;
    	ListNode checkNode = null;
    	
    	do{
    		checkNode = addListNodeSafely(t1, t2);
    		if(null == head){
    			head = checkNode;
    			curr = head;
    		} else {
    			curr.next = checkNode;
    			curr = checkNode;
    		}
    		if(null != t1)
    			t1 = t1.next;
    		if(null != t2)
    			t2 = t2.next;
    	} while( null != checkNode);
    	
    	curr = head;
    	while(null != curr){
    		int left = curr.val%10;
    		int inc = (curr.val - left)/10;
    		curr.val = left;
    		if(inc > 0){
	    		if(null != curr.next){
	    			curr.next.val +=inc;
	    		} else {
	    			ListNode next = new ListNode(inc);
	    			curr.next = next;
	    		}
    		}
    		curr = curr.next;
    	}    	
    	return head;
    }
    
    private ListNode addListNodeSafely(ListNode l1, ListNode l2){
    	if(null != l1 && null != l2){
    		return new ListNode(l1.val + l2.val);
    	} else if (null == l1 ) {
    		if(null == l2){
    			return null;
    		} else {
    			return new ListNode(l2.val);
    		}
    	} else {//null == l2
    		return new ListNode(l1.val);
    	} 
    }
    
    public static void main(String args[]){
    	ListNode l1 = new ListNode(0);
    	l1.next = new ListNode(3);
    	ListNode l2 = new ListNode(0);
    	l2.next = new ListNode(7);
    	ListNode sum = new AddTwoNumber().addTwoNumbers(l1, l2);
    	ListNode node = sum;
    	while(null != node){
    		System.out.print(node.val+",");
    		node = node.next;
    	}
    }

}
