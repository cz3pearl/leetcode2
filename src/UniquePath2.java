import org.junit.Test;


public class UniquePath2 {
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int xLen = obstacleGrid.length;
        int yLen = obstacleGrid[0].length;
        int[][] attach = new int[xLen+1][yLen+1];
        for(int i = 0; i <=xLen; i++){
        	for(int j = 0; j <=yLen; j++){
        		attach[i][j] = 0;
        	}
        }
        
        for(int i = xLen -1; i>=0; i--){
        	for(int j = yLen-1; j>=0; j--){
        		if(i == xLen -1 && j == yLen -1) {
	        		if(1 != obstacleGrid[xLen -1][yLen -1]){
	                	attach[xLen-1][yLen-1] = 1;
	                }
        		} else {
	        		if(1 != obstacleGrid[i][j])
	        			attach[i][j] = attach[i+1][j] + attach[i][j+1];
	        		else
	        			attach[i][j] = 0;
        		}
        	}
        }
        return attach[0][0];
    }
    
    @Test
    public void test(){
    	int[][] obstacleGrid = new int[][]{{0}};
    	System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    
}
