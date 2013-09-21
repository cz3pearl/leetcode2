
public class Palindrome2 {
	
	public int minCut(String s) {
		char[] array = s.toCharArray();
		int[] attatchedArray = new int[array.length];
		for(int i = 0; i < attatchedArray.length; i++){
			attatchedArray[i] = -1;
		}
		return minPalindromeSplit(array,0,attatchedArray);
    }
	
	public int minPalindromeSplit(char[] array, int start , int[] attachedArray){
		if(attachedArray[start]>0)
			return attachedArray[start];
		int min = array.length-1-start;
		int lenLimit = array.length-start-1;
		int end = findMaxPalindrome(array,start,lenLimit);
		int cut = 0;
		while(end >= 0){
			if(end <= array.length-1){
				if(end == array.length -1){
					min = 0;
					break;
				} else {
					int nextStart = end+1;
					if(attachedArray[nextStart] >0)
						cut = attachedArray[nextStart] + 1;
					else
						cut = minPalindromeSplit(array, nextStart, attachedArray) + 1;
					if(min > cut){
						min = cut;
					}
				}
			}
			if(min == 0)
				break;
			end = findMaxPalindrome(array,start,end-start-1);
		}
		attachedArray[start]=min;
		return min;
	}
	
	public int findMinPalindrome(char[] array, int start, int lenLimit){
		for(int i = start+lenLimit; i< array.length; i++){
			if(checkIsPalindrome(array, start, i)){
				return i;
			}
		}
		return -1;
	}
	
	public int findMaxPalindrome(char[] array, int start, int lenLimit){
		for(int i = start+lenLimit; i>=start; i--){
			if(checkIsPalindrome(array, start, i)){
				return i;
			}
		}
		return -1;
	}
	
	public  boolean checkIsPalindrome(char[] array, int start, int end){
		while(end > start){
			if(array[end--] != array[start++])
				return false;
		}
		return true;
	}
	
	public static void main(String args[]){
		Palindrome2 split = new Palindrome2();
		System.out.println(split.minCut("cddddc"));
	}
}
