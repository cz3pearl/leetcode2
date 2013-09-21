import org.junit.Test;


public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int xLen = matrix.length;
        if(xLen > 0){
        	int yLen = matrix[0].length;
        	int total = xLen * yLen;
        	return searchMatrix(matrix, yLen, target, 0, total-1);
        } else {
        	return false;
        }
    }
    
    public boolean searchMatrix(int[][] matrix, int yLen, int target, int start, int end){
    	if(start == end){
    		Point p = new Point(start, yLen);
    		if(matrix[p.x][p.y] == target){
    			return true;
    		} else {
    			return false;
    		}
    	} else if (start < end) {
	    	Point pStart = new Point(start, yLen);
	    	Point pEnd = new Point(end, yLen);
	    	if(matrix[pStart.x][pStart.y] > target || matrix[pEnd.x][pEnd.y] < target){
	    		return false;
	    	} else {
	    		int mid = (start + end)/2;
	    		Point pMid = new Point(mid, yLen);
	    		int vMid = matrix[pMid.x][pMid.y];
	    		if( vMid == target){
	    			return true;
	    		} else if (vMid > target) {
	    			return searchMatrix(matrix, yLen, target, start, mid -1 );
	    		} else {
	    			return searchMatrix(matrix, yLen, target, mid + 1, end );
	    		}
	    	}
    	} else {
    		return false;
    	}
    }
    
    public static class Point{
    	int x;
    	int y;
    	
    	Point(int v, int yLen){
    		this.x = v/yLen;
    		this.y = v%yLen;
    	}
    }
    
    
    @Test
    public void test(){
    	int[][] matrix = new int[][]{ {1},{3}};
    	int target = 1;
    	System.out.println(searchMatrix(matrix, target));
    }
    
}
