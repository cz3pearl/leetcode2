
public class SameTree {
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == q) || ( 
	        	(null !=p && null!=q)
	        	&&	(p.val == q.val)
	        	&&  isSameTree(p.left, q.left)
	        	&&  isSameTree(p.right, q.right)
        	);
    }
}
