
public class PartitionList {
	
    public ListNode partition(ListNode head, int x) {
    	ListNode newHead = head;
    	ListNode lastBeforeBigger = null;
    	ListNode firstBigger = null;
    	ListNode biggerListEnd = null;
    	ListNode indexer = head;
    	ListNode next = null;
    	while(null != indexer){
    		next = indexer.next;
    		if(null == firstBigger){
	    		if(indexer.val < x){
	    			lastBeforeBigger = indexer;
	    		} else {
	    			firstBigger = indexer;
	    			if(null != lastBeforeBigger)
	    				lastBeforeBigger.next = firstBigger;
	    			biggerListEnd = indexer;
	    		}
    		} else {
    			if(indexer.val < x){
	    			if(null == lastBeforeBigger){
	    				newHead = indexer;
	    			} else {
	    				lastBeforeBigger.next = indexer;
	    				indexer.next = firstBigger;
	    			}
	    			lastBeforeBigger = indexer;
	    			indexer.next = firstBigger;
    			} else {
    				biggerListEnd.next = indexer;
    				biggerListEnd = indexer;
    				indexer.next = null;
    			}
    		}
    		if(null != biggerListEnd)
    			biggerListEnd.next = next;
    		indexer = next;
    	}
    	return newHead;
    }
    
    public static void main(String args[]){
    	ListNode node = new ListNode(2);
    	ListNode next = new ListNode(1);
    	node.next = next;
    	PartitionList pl = new PartitionList();
    	System.out.println(Util.strListNode(pl.partition(node, 2)));
    }
}
