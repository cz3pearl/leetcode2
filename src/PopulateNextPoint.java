
public class PopulateNextPoint {

	private static class TreeLinkNode {
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;
	}
	
	private void connect(TreeLinkNode left, TreeLinkNode right){
		while(null != left){
			left.next = right;
			left = left.right;
			right = right.left;
    	}
	}
	
    public void connect(TreeLinkNode root) {
    	TreeLinkNode downLevel = root;
    	while(null != downLevel){
    		TreeLinkNode exeNode = downLevel;
    		downLevel = exeNode.left;
    		while(null != exeNode){
	    		TreeLinkNode left = exeNode.left;
	    		TreeLinkNode right = exeNode.right;
	    		connect(left, right);
	    		exeNode = exeNode.next;
    		}    		
    	}    	
    }
    
//    public static void main(String args[]){
//    	TreeLinkNode one = new TreeLinkNode(1);
//    	TreeLinkNode two = new TreeLinkNode(2);
//    	TreeLinkNode thr = new TreeLinkNode(3);
//    	TreeLinkNode fou = new TreeLinkNode(4);
//    	TreeLinkNode fiv = new TreeLinkNode(5);
//    	TreeLinkNode six = new TreeLinkNode(6);
//    	TreeLinkNode sev = new TreeLinkNode(7);
//    	
//    	one.left = two;
//    	one.right = thr;
//    	two.left = fou;
//    	two.right = fiv;
//    	thr.left = six;
//    	thr.right = sev;
//    	
//    	new PopulateNextPoint().connect(one);
//    	System.out.println("Done!");
//    }
}
