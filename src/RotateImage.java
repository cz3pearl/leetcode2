import org.junit.Test;


public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i < len/2; i++){
        	for(int j = i; j < len - 1 -i; j++){
        		int t = matrix[len-1-j][i];
        		matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
        		matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
        		matrix[j][len-1-i] = matrix[i][j];
        		matrix[i][j] = t;
        	}
        }        
    }
    
    @Test
    public void test(){
    	int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	rotate(matrix);
    	for(int[] array : matrix){
    		System.out.println(Util.intArrayStr(array));
    	}
    }
}
