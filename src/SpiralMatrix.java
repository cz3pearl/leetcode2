import java.util.ArrayList;

import org.junit.Test;


public class SpiralMatrix {

	
	private static final int RIGHT = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int UP = 3;
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int xLen = matrix.length;
        if(xLen == 0)
        	return result;
        int yLen = matrix[0].length;
		boolean[][] attach = new boolean[xLen][yLen];
		for(int i = 0; i < xLen; i++){
			for(int j = 0; j < yLen; j++){
				attach[i][j] = true;
			}
		}
		Point p = new Point(0,0,RIGHT);
		while(null != p){
			result.add(matrix[p.x][p.y]);
			attach[p.x][p.y] = false;
			p = findNext(attach, p);
		}
		return result;
    }
	
	
	private Point findNext(boolean[][] attach, Point point){
		int xLen = attach.length;
		if(0 == xLen)
			return null;
		int yLen = attach[0].length;

		int direction = point.direction;
		int times = 4;
		while(times-- > 0){
			int retX = point.x;
			int retY = point.y;
			switch(direction%4){
			case RIGHT:
				retY = point.y + 1;
				break;
			case DOWN:
				retX = point.x + 1; 
				break;
			case LEFT:
				retY = point.y - 1;
				break;
			case UP:
				retX = point.x - 1;
				break;
			}
			
			if(retX >=0 && retX < xLen && retY >=0 && retY < yLen && attach[retX][retY]){
				return new Point(retX, retY, direction%4);
			} else {
				direction++;
			}
		}
		return null;
	}
	
	private static class Point{
		int direction;
		int x;
		int y;
		Point(int x, int y, int direction){
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}
	
	@Test
	public void test(){
		int[][] grid = new int[][]{
				{1,2,3,4},
				{12,13,14,5},
				{11,16,15,6},
				{10,9,8,7}};
		System.out.println(spiralOrder(grid));
	}
}
