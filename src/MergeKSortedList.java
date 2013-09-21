import java.util.ArrayList;

import org.junit.Test;


public class MergeKSortedList {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNodeHeap lnh = new ListNodeHeap(lists);
        ListNode tHead = new ListNode(1);
        ListNode tail = tHead;
        ListNode top = lnh.getTop();
        while(null != top){
        	tail.next = top;
        	tail = top;
        	ListNode next = top.next;
        	lnh.setTop(next);        	
        	top = lnh.getTop();
        }
        return tHead.next;
    }
    
    public static class ListNodeHeap{
    	int size;
    	ListNode[] heap;
    	
    	public ListNodeHeap(ArrayList<ListNode> lists){
    		int listSize = lists.size();
    		heap = new ListNode[listSize];
    		int arrayIdx = 0;
    		int listIdx = 0;
    		for(; listIdx < listSize; listIdx++){
    			ListNode node = lists.get(listIdx);
    			if(null != node){
    				heap[arrayIdx++] = node;
    			}
    		}
    		size = arrayIdx;
    		buildHeap();
    	}
    	
    	public ListNode getTop(){
    		return get(0);
    	}
    	
    	public void setTop(ListNode node){
    		if(null != node){
    			heap[0] = node;
    			adjustHeap(0);
    		} else {
    			if(size > 0){
    				swap(0, size-1);
    			}
    			size--;
    			adjustHeap(0);
    		}
    	}
    	
    	public ListNode get(int i){
    		if(i < size)
    			return heap[i];
    		else
    			return null;
    	}
    	
    	private void buildHeap(){
    		for(int i = size/2; i >=0; i--){
    			adjustHeap(i);
    		}
    	}
    	
    	private void adjustHeap(int i){
    		int left = 2*i+1;
    		int right = 2*i+2;
    		int minIdx = i;
    		if(left < size && heap[left].val < heap[minIdx].val){
    			minIdx = left;
    		}
    		
    		if(right < size && heap[right].val < heap[minIdx].val){
    			minIdx = right;
    		}
    		
    		if(minIdx != i){
    			swap(minIdx, i);
    			adjustHeap(minIdx);
    		}
    	}
    	
    	private void swap(int i, int j){
    		ListNode t = heap[i];
    		heap[i] = heap[j];
    		heap[j] = t;
    	}
    }
    
    @Test
    public void test(){
    	ArrayList<ListNode> lists = new ArrayList<ListNode>();
    	String[] nodeStrs = new String[]{"1,2,3,4,5,6","-2,-1,3,4,5,6"};
    	for(String nodeStr : nodeStrs){
    		lists.add(Util.parseListNode(nodeStr));
    	}
    	System.out.println(Util.strListNode(mergeKLists(lists)));
    }
}
