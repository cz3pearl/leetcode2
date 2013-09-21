
public class SumRootToLeafNumber {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		return sumNum(root);
	}
	
	private int sumNum(TreeNode node){
		return sumNum(node,0);
	}
	
	private int sumNum(TreeNode node, int lastSum){
		int sum = 0;
		if(null == node){
			return sum;
		} else if (null == node.left && null == node.right){
			sum = lastSum*10 + node.val;
		}else {
			int levelSum = lastSum*10+node.val;
			if(null != node.left){
				sum += sumNum(node.left, levelSum);
			}
			if(null != node.right){
				sum += sumNum(node.right, levelSum);
			}				
		}
		return sum;			
	} 
	public static void main(String args[]){
		TreeNode root = new TreeNode(4);
		TreeNode nine = new TreeNode(9);
		TreeNode one = new TreeNode(1);
		TreeNode zero = new TreeNode(0);
		nine.right = one;
		root.left = nine;
		root.right = zero;
		System.out.println(new SumRootToLeafNumber().sumNumbers(root));
	}
}
