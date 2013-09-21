import java.util.ArrayList;
import java.util.List;

public class Palindrome1 {

	ArrayList<ArrayList<String>> cutPalindrome(String str){
		int strLen = str.length();
		ArrayList<ArrayList<String>> retList = new ArrayList<ArrayList<String>>();
		if(strLen == 1){
			ArrayList<String> tList = new ArrayList<String>();
			tList.add(str);
			retList.add(tList);
			return retList;
		} else {
			int len = 0;
			while(len >=0){
				ArrayList<String> tList = new ArrayList<String>();
				// find the first palindrome String len
				
					tList.add(str.substring(0, len+1));
					if(len+1 < strLen){
						//there is subString to process
						ArrayList<ArrayList<String>> subCuts = cutPalindrome(str.substring(len+1));
						for(ArrayList<String> list: subCuts){
							list.addAll(0, tList);
						}
						retList.addAll(subCuts);
					} else {
						//no subString to process
						retList.add(tList);
						return retList;
					}
					len = findPalindromeLen(str, len);
			}
		}
		
		return retList;
	}
	
	/*
	 * return the len of the first Palindrome String 
	 * which is longer than lenToBigger
	 * if no String meets the requirement
	 * reutrn -1
	 */
	int findPalindromeLen(String str,int lenToBigger){
		int len = str.length();
		int endIdx = lenToBigger + 1;
		while(endIdx < len){
			if(isPalindrome(str, 0, endIdx))
				return endIdx;
			endIdx++;
		}
		return -1;
	}
	
	/*
	 * Check if a String from fromIdx to endIdx [fromIdx, endIdx] is a Palindrome String
	 */
	boolean isPalindrome(String str, int fromIdx, int endIdx){
		boolean ret = true;
		while(fromIdx<=endIdx){
			if(str.charAt(fromIdx++) != str.charAt(endIdx--))
				ret = false;
		}
		return ret;
	}
	
	
//	public static void main(String args[]){
//		String str = "adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece";
//		Palindrome1 p = new Palindrome1();
//		ArrayList<ArrayList<String>> retList = p.cutPalindrome(str);
//		for(List<String> list : retList){
//			if(list.size() == 273 || list.size() == 281){
//				System.out.println(list.size());
//				for(String tStr : list){
//					System.out.print(tStr + ",");
//				}
//				System.out.println();
//			}
//		}
//	}
}
