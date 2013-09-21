import org.junit.Test;


public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
    	if(null == head){
    		return null;
    	}
    	ListNode nHead = null;
    	ListNode nTail = null;
    	ListNode vNode = null;
    	ListNode curr = head;
    	boolean vdup = false;
    	while(null != curr){
    		if(null == vNode){
    			vNode = curr;
    		} else {
    			if(curr.val == vNode.val){
    				vdup = true;
    			} else {
    				if(!vdup){
    					if(null != nTail){
    						nTail.next = new ListNode(vNode.val);
    						nTail = nTail.next;
    					} else {
    						nHead = new ListNode(vNode.val);
    						nTail = nHead;
    					}
    				}
    				vNode = curr;
    				vdup = false;
    			}
    		}
    		curr = curr.next;
    	}
    	
    	if(!vdup){
    		if(null != vNode){
	    		if(null != nTail){
					nTail.next = new ListNode(vNode.val);
				} else {
					nHead = new ListNode(vNode.val);
					nTail = nHead;
				}
    		}
    	}
    	return nHead;
    }
    
    @Test
    public void testDedup(){
    	String listStr = "1,2,3";
    	ListNode node = Util.parseListNode(listStr);
    	System.out.println(Util.strListNode(deleteDuplicates(node)));
    }
}
