import org.junit.Test;


public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1)
        	return l2;
        if(null == l2)
        	return l1;
    	ListNode head = null;
        ListNode tail = null;
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;
        while(null != l1Curr && null != l2Curr){
        	ListNode next = null;
        	if(l1Curr.val <= l2Curr.val){
        		next = l1Curr;
        		l1Curr = l1Curr.next;
        	} else {
        		next = l2Curr;
        		l2Curr = l2Curr.next;
        	}
        	
        	if(null != head){
    			tail.next = next;
    			tail = tail.next;
    		} else {
    			head = next;
    			tail = head;
    		}
        	tail.next = null;
        }
        if(null != l1Curr){
        	tail.next = l1Curr;
        }
        if(null != l2Curr){
        	tail.next = l2Curr;
        }
        return head;
    }
    
    @Test
    public void test(){
    	String list1Str = "1,3,5,7,9,13,100,1000";
    	String list2Str = "2,4,6,8,10,11,12";
    	System.out.println(Util.strListNode(mergeTwoLists(Util.parseListNode(list1Str),Util.parseListNode(list2Str))));
    }
}
