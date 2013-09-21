

public class PopulateNextPoint2 {


	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	private TreeLinkNode getLeftMost(TreeLinkNode node){
		TreeLinkNode leftMost = null;
		if(null != node){
			leftMost = node.left;
			if(null == leftMost)
				leftMost = node.right;
		}
		return leftMost;
	}
	
	private void linkNodeLeftRight(TreeLinkNode node){
		if(null != node){
			if(null != node.left && null != node.right)
				node.left.next = node.right;
		}
	}
	
	private TreeLinkNode getRightMost(TreeLinkNode node){
		TreeLinkNode rightMost = null;
		if(null != node){
			rightMost = node.right;
			if(null == rightMost)
				rightMost = node.left;
			return rightMost;
		}
		return rightMost;
	}
	
	 public void connect(TreeLinkNode root) {
		TreeLinkNode highNode = root;
		while(null != highNode){
			//find next highLowNode
			TreeLinkNode nextHighLowNode = getLeftMost(highNode);
			while(null == nextHighLowNode && null != highNode){
				highNode = highNode.next;
				nextHighLowNode = getLeftMost(highNode);
			}
			
			if(null != highNode){
				linkNodeLeftRight(highNode);
				TreeLinkNode processLowRight = getRightMost(highNode);
				highNode = highNode.next;
				while(null != highNode){
					//set all sibling in highNode connected
					linkNodeLeftRight(highNode);
					TreeLinkNode leftMost = getLeftMost(highNode);
					if(null != leftMost){
						processLowRight.next = leftMost;
						processLowRight = getRightMost(highNode);
					}
					highNode = highNode.next;
				}
				
				highNode = nextHighLowNode;
			}
		}
	}
	 
	 
	    public static void main(String args[]){
	    	TreeLinkNode one = new TreeLinkNode(1);
	    	TreeLinkNode two = new TreeLinkNode(2);
	    	TreeLinkNode thr = new TreeLinkNode(3);
	    	TreeLinkNode fou = new TreeLinkNode(4);
	    	TreeLinkNode fiv = new TreeLinkNode(5);
	    	TreeLinkNode six = new TreeLinkNode(6);
	    	TreeLinkNode sev = new TreeLinkNode(7);
	    	
	    	one.left = two;
	    	one.right = thr;
	    	two.left = fou;
	    	two.right = fiv;
	    	thr.left = six;
	    	thr.right = sev;
	    	
	    	new PopulateNextPoint2().connect(one);
	    	System.out.println("Done!");
	    }
}
