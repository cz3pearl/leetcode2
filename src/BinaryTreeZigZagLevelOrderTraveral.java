import java.util.ArrayList;

public class BinaryTreeZigZagLevelOrderTraveral {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    	levelTraveral(root, list, 0);
    	int size = list.size();
    	for(int i = 0; i < size; i++){
    		if(i%2 == 1){
    			ArrayList<Integer> line = list.get(i);
    			int lSize = line.size();
    			for(int s = 0, e = lSize-1; s < e; s++,e--){
    				Integer sV = line.get(s);
    				Integer eV = line.get(e);
    				line.set(s, eV);
    				line.set(e, sV);    				
    			}
    		}
    	}
    	return list;
    }
    
    public void levelTraveral(TreeNode node, ArrayList<ArrayList<Integer>>list, int level){
    	if(null != node){
	    	ArrayList<Integer> line = null;
	    	int size = list.size();
	    	if(level < size){
	    		line = list.get(level);
	    	} else {
	    		line = new ArrayList<Integer>();
	    		list.add(line);
	    	}
	    	if(null != node.left)
	    		levelTraveral(node.left, list, level+1);
	    	line.add(node.val);
	    	if(null != node.right)
	    		levelTraveral(node.right, list, level+1);
    	}
    }
}
