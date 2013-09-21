import org.junit.Test;


public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] intBoard = new int[9][9];
        for(int i = 0; i < 9; i++){
        	for(int j = 0; j < 9; j++){
        		if(board[i][j] == '.'){
        			intBoard[i][j] = 0;
        		} else {
        			intBoard[i][j] = board[i][j] - '0';
        		}
        	}
        }
        return isValidSudoku(intBoard);
    }
    
    private boolean isValidSudoku(int[][] board){
    	for(int i = 0; i < 9; i++){
    		for(int j = 0; j < 9; j++){
    			if(0 != board[i][j]){
    				if(verValid(board, i, j) && horValid(board, i, j) && blockValid(board, i, j)){
    					
    				} else {
    					System.out.println( i + "," + j );
    					System.out.println("VerValid"+verValid(board,i,j));
    					System.out.println("VerValid"+horValid(board,i,j));
    					System.out.println("VerValid"+blockValid(board,i,j));
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }
    
    private boolean verValid(int[][] board, int i, int j){
    	int v = board[i][j];
    	for(int x = 0; x < 9; x++){
    		if(i!=x){
    			if(board[x][j] == v)
    				return false;
    		}
    	}
    	return true;
    }
    
    private boolean horValid(int[][] board, int i, int j){
    	int v = board[i][j];
    	for(int y = 0; y < 9; y++){
    		if(j != y){
    			if(board[i][y] == v)
    				return false;
    		}
    	}
    	return true;
    }
    
    private boolean blockValid(int[][]board, int i, int j){
    	int xBase = (i/3)*3;
    	int yBase = (j/3)*3;
    	for(int x = 0; x < 3; x++){
    		for(int y = 0; y < 3; y++){
    			int rx = xBase + x;
    			int ry = yBase + y;
    			if(rx != i || ry != j){
    				if(board[rx][ry] == board[i][j])
    					return false;
    			}
    		}
    	}
    	return true;
    }
    
    @Test
    public void test(){
    	String[] strs = new String[]{"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"};
    	char[][] board = new char[9][9];
    	int i = 0;
    	for(String str : strs){
    		board[i++] = str.toCharArray();
    	}
    	System.out.println(isValidSudoku(board));
    }
    
    
}
