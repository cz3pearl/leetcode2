import org.junit.Test;


public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
    	int xLen = grid.length;
    	int yLen = grid[0].length;
        int[][] attach = new int[xLen][yLen];
        attach[xLen-1][yLen -1] = grid[xLen -1][yLen -1];
        int x = xLen-1;
        for(int y = yLen-2; y >=0; y--){
        	attach[x][y] = attach[x][y+1]+grid[x][y];
        }
        int y = yLen -1;
        for(x = xLen-2; x >=0; x--){
        	attach[x][y] = attach[x+1][y]+grid[x][y];
        }
        
        for(x = xLen -2; x>=0; x--){
        	for(y = yLen -2; y>=0; y--){
        		attach[x][y] = grid[x][y]+Math.min(attach[x+1][y], attach[x][y+1]);
        	}
        }
        return attach[0][0];
    }
    
    @Test
    public void test(){
    	int[][] grid = new int[][]{{1,2},{1,1}};
    	System.out.println(minPathSum(grid));
    }
}
