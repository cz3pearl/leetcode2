import java.util.ArrayList;
import java.util.List;


public class UniqueBinarySearchTree {

    public ArrayList<TreeNode> generateTrees(int n) {
       if(n == 0){
           ArrayList<TreeNode> result = new ArrayList<TreeNode>();
           result.add(null);
           return result;
       }
 	   List<List<Integer>> list = generateAllSeq(n);
 	   List<Integer> inOrder = new ArrayList<Integer>();
 	   for(int i = 1; i <= n; i++){
 		   inOrder.add(i);
 	   }
 	   ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
 	   for(List<Integer> oneList : list){
 		   TreeNode node = generateBinarySearchTree(inOrder, oneList);
 		   if(null != node){
 			   nodes.add(node);
 		   }
 	   }
 	   return nodes;
    }
    
   public TreeNode generateBinarySearchTree(List<Integer> inOrder, List<Integer> preOrder){
    	int inOrderSize = inOrder.size();
    	int preOrderSize = preOrder.size();
    	
    	if(inOrderSize > 0 && inOrderSize == preOrderSize){
	    	int size = inOrderSize;
	    	if(size == 1){
	    		if(inOrder.get(0) == preOrder.get(0)){
	    			return new TreeNode(inOrder.get(0));
	    		} else {
	    			return null;
	    		}
	    	} else {
	    		Integer rootNo = preOrder.get(0);
	    		TreeNode root = new TreeNode(rootNo);
	    		int rootIdx = inOrder.indexOf(rootNo);
	    		if(rootIdx < 0){
	    			return null;
	    		} else {
	    			List<Integer> inOrderLeftNodes = inOrder.subList(0, rootIdx);
	    			List<Integer> inOrderRightNodes = inOrder.subList(rootIdx+1,size);
	    			List<Integer> preOrderLeftNodes = preOrder.subList(1, 1+inOrderLeftNodes.size());
	    			List<Integer> preOrderRightNodes = preOrder.subList(1+preOrderLeftNodes.size(),size);
	    			if(inOrderLeftNodes.size() > 0){
	    				TreeNode left = generateBinarySearchTree(inOrderLeftNodes, preOrderLeftNodes);
	    				if(null != left){
	    					root.left = left;
	    				} else {
	    					return null;
	    				}
	    			}
	    			if(preOrderRightNodes.size() > 0){
	    				TreeNode right = generateBinarySearchTree(inOrderRightNodes, preOrderRightNodes);
	    				if(null != right){
	    					root.right = right;
	    				} else {
	    					return null;
	    				}
	    			}
	    			return root;
	    		}
	    	}
    	} else {
    		return null;
    	}
    }

   public List<List<Integer>> generateAllSeq(int n){
	   List<List<Integer>> list = new ArrayList<List<Integer>>();
	   if(n == 1){
		   List<Integer> oneList = new ArrayList<Integer>();
		   oneList.add(1);
		   list.add(oneList);
	   } else {
		   List<List<Integer>> subList = generateAllSeq(n-1);
		   for(List<Integer> oneList : subList){
			   for(int i = 0; i <= oneList.size(); i++){
				   List<Integer> tList = new ArrayList<Integer>();
				   tList.addAll(oneList);
				   tList.add(i, n);
				   list.add(tList);
			   }
		   }
	   }
	   return list;
   }
}
