import java.util.ArrayList;


public class NQueens2 {
	
	private int count;
    public int totalNQueens(int n) {
    	count = 0;
    	boolean[][] attach = new boolean[n][n];
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		attach[i][j] = false;
        	}
        }
        resolveNQueens(0, n, attach);
        return count;
    }
    
    private void resolveNQueens(int level, int n, boolean[][] map){
    	for(int j = 0 ; j < n; j++){
    		if(isValid(level, j, n, map)){
    			map[level][j]=true;
    			if(level == n-1){
    				count++;
    			}
    			if(level < n-1)
    				resolveNQueens(level+1, n, map);
    			map[level][j] = false;
    		}
    	}
    }
    
    private boolean isValid(int i, int j, int n, boolean[][] map){
    	return horValid(i, j, n, map) 
    			&& xDownValid(i, j, n, map) 
    			&& xUpValid(i, j, n, map);
    }
    
    private boolean horValid(int i, int j, int n, boolean[][] map){
    	for(int x = 0; x < i; x++){
//    		if(x!=i){
    			if(map[x][j]){
    				return false;
    			}
//    		}
    	}
    	return true;
    }
    
    private boolean xDownValid(int i, int j, int n, boolean[][] map){
    	int x; 
    	int y;
//    	x = i+1;
//    	y = j+1;
//    	while( x >= 0 &&  x < n &&  y >= 0 && y < n){
//			if(map[x][y]){
//				return false;
//			}
//    		x++;
//    		y++;
//    	}
    	
    	x = i - 1;
    	y = j - 1;
    	while( x >= 0 &&  x < n &&  y >= 0 && y < n){
			if(map[x][y]){
				return false;
			}
    		x--;
    		y--;
    	}
    	
    	return true;
    }
    
    private boolean xUpValid(int i , int j, int n, boolean[][] map){
    	int x;
    	int y;
//    	x = i+1;
//    	y = j-1;
//    	while( x >= 0 &&  x < n &&  y >= 0 && y < n){
//			if(map[x][y]){
//				return false;
//			}
//    		x++;
//    		y--;
//    	}
    	
    	x = i - 1;
    	y = j + 1;
    	while( x >= 0 &&  x < n &&  y >= 0 && y < n){
			if(map[x][y]){
				return false;
			}
    		x--;
    		y++;
    	}
    	
    	return true;
    }
}
