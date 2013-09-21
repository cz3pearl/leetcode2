import java.util.LinkedList;


public class FlattenBinaryTree {


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public void flatten(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        process(root, list);
        int size = list.size();
        for(int i = 0; i < size-1; i++){
        	TreeNode node = list.get(i);
        	TreeNode next = list.get(i+1);
        	node.left = null;
        	node.right = next;
        }
    }
    
    private void process(TreeNode node, LinkedList<TreeNode> list){
    	if(null != node){
    		list.add(node);
    		process(node.left, list);
    		process(node.right, list);
    	}
    }
	
}
