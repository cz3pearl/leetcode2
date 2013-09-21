import java.util.ArrayList;


public class BinaryTreeReverseLevelOrderTraveral {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
	}
	
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        traverseToBottom(list, 0, root);
        int size = list.size();
        for(int i = 0, j=size-1; i<j; i++, j--){
        	ArrayList<Integer> iLevelList = list.get(i);
        	ArrayList<Integer> jLevelList = list.get(j);
        	list.set(i, jLevelList);
        	list.set(j, iLevelList);
        }
        return list;
    }	
    
    private void traverseToBottom(ArrayList<ArrayList<Integer>> list, int level, TreeNode node){
    	if(null != node){
    		ArrayList<Integer> levelList = null;
    		if(level < list.size()){
    			levelList = list.get(level);
	    	} else {
	    		levelList = new ArrayList<Integer>();
	    		list.add(levelList);
	    	}
    		TreeNode left = node.left;
    		traverseToBottom(list, level+1, left);
    		levelList.add(node.val);
    		TreeNode right = node.right;
    		traverseToBottom(list, level+1, right);	    	
    	}    	
    }
    
    public static void main(String args[]){
    	new BinaryTreeReverseLevelOrderTraveral().levelOrderBottom(new TreeNode(1));
    }
}
