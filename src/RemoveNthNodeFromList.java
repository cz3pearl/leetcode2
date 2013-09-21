import org.junit.Test;


public class RemoveNthNodeFromList {
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode nth = head;
    	while(n-- > 0){
    		nth = nth.next;
    	}
    	
    	ListNode last = null;
    	ListNode visitor = head;
    	while(null != nth){
    		last = visitor;
    		visitor = visitor.next;
    		nth = nth.next;
    	}
    	
    	if(null == last) {
    		return head.next;
    	} else {
    		last.next = visitor.next;
    		return head;
    	}
    }
    
    @Test
    public void test(){
    	ListNode node = Util.parseListNode("1,2,3,4,5,6");
    	ListNode result = removeNthFromEnd(node, 0);
    	System.out.println(Util.strListNode(result));
    }
}
