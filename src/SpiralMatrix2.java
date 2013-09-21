import org.junit.Test;


public class SpiralMatrix2 {
	
	private static final int RIGHT = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int UP = 3;
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        if(0 == n)
        	return ret;
        boolean[][] attach = new boolean[n][n];
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		attach[i][j] = true;
        	}
        }
        
        int startX = 0;
        int startY = 0;
        int v = 1;
        Point currPoint = new Point(startX, startY, RIGHT);
        while(null != currPoint){
        	ret[currPoint.x][currPoint.y] = v++;
        	attach[currPoint.x][currPoint.y] = false;
        	currPoint = nextPoint(n, attach, currPoint);
        }
        return ret;
    }
    
    private Point nextPoint(int len, boolean[][] attach, Point currP){
    	int count = 4;
    	int retx = currP.x;
    	int rety = currP.y;
    	int action = currP.lastAction;
    	while(count-- > 0){
    		switch(action%4){
    		case RIGHT:
    			rety = currP.y + 1;
    			break;
    		case DOWN:
    			retx = currP.x + 1;
    			break;
    		case LEFT:
    			retx = currP.x - 1;
    			break;
    		case UP:
    			rety = currP.y - 1;
    			break;
    		default:
    			return null;
    		}
    		if(retx >= 0 && retx <len && rety >=0 && rety <len && attach[retx][rety]){
    			return new Point(retx, rety, action%4);
    		} else {
    			retx = currP.x;
    			rety = currP.y;
    			action++;
    		}
    	}
    	return null;
    }
    
    private static class Point{
    	public Point(int x, int y, int action){
    		this.x = x;
    		this.y = y;
    		this.lastAction = action;
    	}
    	int lastAction;
    	int x;
    	int y;
    }
    
    @Test
    public void test(){
    	for(int[] array : generateMatrix(4)){
    		System.out.println(Util.intArrayStr(array));
    	}
    }
}
