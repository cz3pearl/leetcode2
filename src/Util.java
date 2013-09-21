
public class Util {

	public static String strListNode(ListNode node){
		StringBuilder sb = new StringBuilder();
		while(null != node){
			sb.append(node.val+",");
			node = node.next;
		}
		return sb.toString();
	}
	
	public static ListNode parseListNode(String nodeStr){
		String[] strs = nodeStr.split(",");
		if(strs.length > 0){
			ListNode head = null;
			ListNode last = null;
			for(String str : strs){
				int val = Integer.parseInt(str);
				if(null == last){
					head = new ListNode(val);
					last = head;
				} else {
					ListNode cNode = new ListNode(val);
					last.next = cNode;
					last = cNode;
				}
			}
			return head;
		} else {
			return null;
		}
	}
	
	public static String intArrayStr(int[] array){
		StringBuilder sb = new StringBuilder();
		for(int i : array){
			sb.append(i+",");
		}
		return sb.toString();
	}
}
