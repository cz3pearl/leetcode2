import java.util.ArrayList;
import java.util.List;


public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int A[], int B[]) {
        int lenA = A.length;
        int lenB = B.length;
        int[] sa;
        int[] la;
        int sLen;
        int lLen;
        if(lenA >= lenB){
        	la = A;
        	lLen = lenA;
        	sa = B;
        	sLen = lenB;
        	
        } else {
        	la = B;
        	lLen = lenB;
        	sa = A;
        	sLen = lenA;
        }
        
        if(0 == sLen){
        	if(lLen%2 == 1){
        		return la[lLen/2+1-1];
        	} else {
        		return (la[lLen/2 -1] + la[lLen/2 + 1 -1])/2.0;
        	}
        }
        int total = lLen + sLen;
        
        int div = 2;
        int lIdx = lLen/div;
        int llIdx = lLen -1;
        int lsIdx = 0;
        int sIdx = sLen/div;
        int slIdx = sLen -1;
        int ssIdx = 0;
        while(	(sIdx < sLen-1) 
				&& (sIdx >= 0)
				&& (lIdx < lLen -1)
				&& (lIdx >= 0) 
				){
        	
        	if(sa[sIdx] > la[lIdx]){
        		if(sa[sIdx] > la[lIdx+1]){
        			int nsIdx = sIdx - ((sIdx - ssIdx)/2 + 1);
        			int nlIdx = lIdx + (sIdx - nsIdx);
        			slIdx = sIdx-1;
        			lsIdx = lIdx+1;
        			sIdx = nsIdx;
        			lIdx = nlIdx;
        		} else {
        			break;
        		}
        	} else if (sa[sIdx] < la[lIdx]){
        		if(sa[sIdx+1] < la[lIdx]){
        			int nsIdx = sIdx + (slIdx - sIdx)/2 + 1;
        			int nlIdx = lIdx - (nsIdx - sIdx);
        			ssIdx = sIdx+1;
        			llIdx = lIdx-1;
        			sIdx = nsIdx;
        			lIdx = nlIdx;
        		} else {
        			break;
        		}
        	} else {
        		break;
        	}
        }        

        System.out.println(sIdx + "," + lIdx);
        if(total%2 == 1){
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	if(sIdx >=0 ){
        		list.add(sa[sIdx]);
        		if(sIdx > 0){
        			list.add(sa[sIdx - 1]);
        		}
        	}
        	
        	if(lIdx >=0 ){
        		list.add(la[lIdx]);
        		if(lIdx > 0){
        			list.add(la[lIdx - 1]);
        		}
        	}
        	
        	return topSec(list);
        } else {
        	if(sLen%2 == 1){
        		int m1 = lIdx > 0 ? ( sIdx >= 0 ? Math.max(sa[sIdx], la[lIdx-1]) : la[lIdx -1] ) : sa[sIdx];
        		int m2 = sIdx > 0 ? ( lIdx >= 0 ? Math.max(sa[sIdx-1], la[lIdx]) : sa[sIdx-1] ) : la[lIdx];
        		return (m1 + m2)/2.0;
        	} else {
        		if(sIdx > 0 && lIdx > 0){
        			return ((sa[sIdx] + sa[sIdx-1] + la[lIdx] + la[lIdx-1])
        					- Math.max(sa[sIdx], la[lIdx])
        					- Math.min(sa[sIdx-1], la[lIdx -1]))/2.0;
        		} else {
        			if(sIdx == 0){
        				if(lIdx < lLen){
        					return ( sa[sIdx] + la[lIdx]+ la[lIdx-1]) - Math.min(sa[sIdx],la[lIdx-1])/2.0;
        				} else {
        					return (la[lIdx-1] + sa[sIdx])/2.0;
        				}
        			} else if (sIdx < 0){
        				return (la[lIdx]+ la[lIdx-1])/2.0;
        			} else {
        				return (la[lIdx] + sa[sIdx])/2.0;
        			}
        		}
        	}
        }
    }
    
    private double topSec(ArrayList<Integer> vals){
    	assert(vals.size() > 2);
    	int top;
    	int sec;
    	if(vals.get(0) >= vals.get(1)){
    		top = vals.get(0);
    		sec = vals.get(1);
    	} else {
    		top = vals.get(1);
    		sec = vals.get(0);
    	}
    	
    	
    	for(int i = 2; i < vals.size(); i++){
    		int v = vals.get(i);
    		if(v >= top){
    			sec = top;
    			top = v;
    		} else {
    			if(v > sec){
    				sec = v;
    			}
    		}
    	}
    	
    	return sec;
    }
    
    public static void main(String args[]){
//    	[], [2,4,9]
    	int[] A = new int[]{4,5,7,8,9};
    	int[] B = new int[]{1,2,3,6,10};
    	MedianOfTwoSortedArray motsa = new MedianOfTwoSortedArray();
    	System.out.println(motsa.findMedianSortedArrays(A, B));
    }
    
}
