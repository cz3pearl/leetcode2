import org.junit.Test;


public class WordSearch {

    public boolean exist(char[][] board, String word) {
    	if(word.length() == 0)
    		return true;
    	int xMax = board.length;
    	if(xMax == 0)
    		return false;
    	int yMax = board[0].length;
    	boolean[][] trace = new boolean[xMax][yMax];
    	for(int x = 0; x < xMax; x++){
    		for(int y = 0; y < yMax; y++){
    			trace[x][y] = false;
    		}
    	}
    	char headChar = word.charAt(0);
    	Point p = new Point(0,0);
    	p = findNextPointWithChar(board, xMax, yMax, p, headChar);
    	while(null != p){
    		int x = p.x;
    		int y = p.y;
    		trace[x][y] = true;
    		boolean result = exist(board, trace, xMax, yMax, x-1, y, word, 1)
					|| exist(board, trace, xMax, yMax, x+1, y, word, 1)
					|| exist(board, trace, xMax, yMax, x, y-1, word, 1)
					|| exist(board, trace, xMax, yMax, x, y+1, word, 1);
    		if(result)
    			return true;
    		
    		trace[x][y] = false;
    		p.y +=1;
    		p = findNextPointWithChar(board, xMax, yMax, p, headChar);
    	}
    	return false;    	
    }
    
    
    
    public boolean exist(char[][] board, boolean[][] trace, int xMax, int yMax, int x, int y, String word, int idx){
    	if(word.length() <= idx){
    		return true;
    	} else {
    		char c = word.charAt(idx);
    		if(x < 0 || x >= xMax || y < 0 || y >=yMax)
        		return false;
    		if(trace[x][y] == true)
    			return false;
    		if(board[x][y] == c){
    			trace[x][y] = true;
    			boolean result = exist(board, trace, xMax, yMax, x-1, y, word, idx+1)
    					|| exist(board, trace, xMax, yMax, x+1, y, word, idx+1)
    					|| exist(board, trace, xMax, yMax, x, y-1, word, idx+1)
    					|| exist(board, trace, xMax, yMax, x, y+1, word, idx+1);
    			trace[x][y] = false;
    			return result;
    		} else {
    			return false;
    		}
    	}
    }
    
    private Point findNextPointWithChar(char[][] board, int xMax, int yMax, Point currPoint, char c){
    	int x = currPoint.x;
    	int y = currPoint.y;
    	for(int i = x; i < xMax; i++){
    		for(int j = y; j < yMax; j++){
    			if(c == board[i][j]){
    				return new Point(i, j);
    			}
    		}
    		y = 0;
    	}
    	return null;
    }
    
    public static class Point{
    	int x;
    	int y;
    	
    	public Point(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    }
    
    @Test
    public void test(){
    	String[] strs = new String[]{"aaaa","aaaa","aaaa","aaaa","aaab"};
    	String word =  "aaaaaaaaaaaaaaaaaaaa";
    	int xLen = strs.length;
    	int yLen = strs[0].length();
    	char[][] board = new char[xLen][yLen];
    	int c = 0;
    	for(String str : strs){
    		board[c++] = str.toCharArray();
    	}
    	System.out.println(exist(board, word));
    }
}
