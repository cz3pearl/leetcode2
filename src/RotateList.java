import org.junit.Test;


public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {
		if(null == head)
			return null;
		ListNode tail = null;
		ListNode curr = head;
		int len = 1;
		while(null != curr.next){
			curr = curr.next;
			len++;
		}
		tail = curr;
		tail.next = head;
		int rotateTime = len - n%len;
		while(rotateTime-- > 0){
			head = head.next;
			tail = tail.next;
		}
		
		tail.next = null;
		return head;
    }
	
	@Test
	public void test(){
		String listNodeStr = "5,20,87,91,53,65,9,59,20,68,16,60,67,84,63,96,37,40,80,37,44,74,54,11,50,66";
		System.out.println(Util.strListNode(rotateRight(Util.parseListNode(listNodeStr), 5)));
	}
}
