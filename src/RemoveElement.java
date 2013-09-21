import org.junit.Test;


public class RemoveElement {

	public int removeElement(int[] A, int elem) {
        int len = A.length;
        int end = len;
        int start = 0;
        for(;start < end;){
        	if(A[start] == elem){
        		swap(A, start, end-1);
        		end--;
        	} else {
        		start++;
        	}
        }
        return end;
    }
	
	private void swap(int[] array, int i, int j){
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	
	
	@Test
	public void test(){
		int[] array = new int[]{1,2,3,9,4,9,5,6,7,8,9};
		int elem = 9;
		System.out.println(removeElement(array, elem));
		System.out.println(Util.intArrayStr(array));
	}
}
