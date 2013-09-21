import java.util.ArrayList;


public class BinaryInOrderTraversal {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(null != root){
        	if(null != root.left)
        		list.addAll(inorderTraversal(root.left));
        	list.add(root.val);
        	if(null != root.right)
        		list.addAll(inorderTraversal(root.right));
        }
       	return list;
    }
}
