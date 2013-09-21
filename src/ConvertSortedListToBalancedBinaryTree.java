
public class ConvertSortedListToBalancedBinaryTree {
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public TreeNode sortedListToBST(ListNode head) {
    	int len = length(head);
    	if(len > 0){
    		return genBinaryTree(head, 0, len);
    	} else {
    		return null;
    	}
    }
    
    private int length(ListNode node){
    	int i = 0;
    	while(null != node){
    		i++;
    		node = node.next;
    	}
    	return i;
    }
    
    private TreeNode genBinaryTree(ListNode node, int start, int end){
    	if(start > end){
    		return null;
    	} else {
    		int mid = (start+end)/2;
    		TreeNode left = genBinaryTree(node, start, mid-1);
    		int val = node.val;
    		TreeNode parent = new TreeNode(val);
    		parent.left = left;
    		if(null != node.next){
    			node.val = node.next.val;
    			node.next = node.next.next;
    			TreeNode right = genBinaryTree(node, mid+1, end);
    			parent.right = right;
    		}
    		return parent;
    	}
    }
	
	 
	
}
