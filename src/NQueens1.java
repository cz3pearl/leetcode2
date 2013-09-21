import java.util.ArrayList;


public class NQueens1 {

    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        boolean[][] attach = new boolean[n][n];
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		attach[i][j] = false;
        	}
        }
        resolveNQueens(0, n, attach, result);
        return result;
    }
    
    private void resolveNQueens(int level, int n, boolean[][] map, ArrayList<String[]> result){
    	for(int j = 0 ; j < n; j++){
    		if(isValid(level, j, n, map)){
    			map[level][j]=true;
    			if(level == n-1){
    				result.add(getResult(n, map));
    			}
    			if(level < n-1)
    				resolveNQueens(level+1, n, map, result);
    			map[level][j] = false;
    		}
    	}
    }
    
    private String[] getResult(int n, boolean[][] map){
    	String[] strs = new String[n];
    	for(int i = 0; i < n; i++){
    		StringBuilder sb = new StringBuilder();
    		for(int j = 0; j < n; j++){
    			if(map[i][j]){
    				sb.append('Q');
    			} else {
    				sb.append('.');
    			}
    		}
    		strs[i] = sb.toString();
    	}
    	return strs;
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
    
    public static void main(String args[]){
    	NQueens1 nQueens = new NQueens1();
    	ArrayList<String[]> results = nQueens.solveNQueens(5);
    	for(String[] strs : results){
    		for(String str : strs){
    			System.out.println(str);
    		}
    		System.out.println("\n");
    	}
    }
}
