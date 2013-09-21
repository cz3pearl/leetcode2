import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


public class SudokuResolver {

	boolean found = false;
	HashSet<Integer> baseSet = new HashSet<Integer>();
	{
		for(int i = 1; i < 10; i++){
			baseSet.add(i);
		}
	}
    public void solveSudoku(char[][] board) {
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
        
        solveSudoku(board, intBoard, new Point(0,0));
        if(found){
        	for(int i = 0; i < 9; i++){
        		for(int j = 0; j < 9; j++){
        			board[i][j] = (char) (intBoard[i][j] + '0');
        		}
        	}
        }
    }
    
    
    private void solveSudoku(char[][] orig, int[][] board, Point p){
    	if(orig[p.x][p.y] != '.'){
    		if( p.x == 8 && p.y == 8){
    			found = true;
    			return;
    		} else {
    			solveSudoku(orig, board, nextSudokuPoint(p));
    		}
    	} else {
    		Set<Integer> lefts = findLeftValues(board, p.x, p.y);
    		for(Integer i : lefts){
    			board[p.x][p.y] = i;
    			if(p.x == 8 && p.y == 8){
    				found = true;
    			} else {
    				solveSudoku(orig, board, nextSudokuPoint(p));
    			}
    			if(found)
    				return;
    		}
    		board[p.x][p.y] = 0;
    	}
    }
    
    private Set<Integer> findLeftValues(int[][] board, int x, int y){
    	HashSet<Integer> set = (HashSet<Integer>) baseSet.clone();
    	removeHor(board, x, y, set);
    	removeVer(board, x, y, set);
    	removeBlock(board, x, y, set);
    	return set;
    }
    
    private void removeHor(int[][] board, int x, int y, Set<Integer> set){
    	for(int j = 0; j < 9; j++){
    		if(j != y){
    			set.remove(board[x][j]);
    		}
    	}
    }
    
    private void removeVer(int[][] board, int x, int y, Set<Integer> set){
    	for(int i = 0; i < 9; i++){
    		if(i != x){
    			set.remove(board[i][y]);
    		}
    	}
    }
    
    private void removeBlock(int[][] board, int x, int y, Set<Integer> set){
    	int baseX = (x/3)*3;
    	int baseY = (y/3)*3;
    	for(int i = 0; i < 3; i++){
    		for(int j = 0; j < 3; j++){
    			int rx = baseX + i;
    			int ry = baseY + j;
    			if(rx != x || ry != y){
    				set.remove(board[rx][ry]);
    			}
    		}
    	}
    }
    
    private static class Point{
    	int x;
    	int y;
    	Point(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    }
    
    private Point nextSudokuPoint(Point p){
    	int y = p.y + 1;
    	int ax = y/9;
    	y = y%9;
    	int x = p.x + ax;
    	if(x >= 9)
    		return null;
    	else
    		return new Point(x, y);
    }
    
    @Test
    public void test(){
    	String[] strs = new String[]{"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"};
    	char[][] board = new char[9][9];
    	int i = 0;
    	for(String str : strs){
    		board[i++] = str.toCharArray();
    	}
    	solveSudoku(board);
    	System.out.println(board);
    }

}
