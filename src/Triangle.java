import java.util.ArrayList;


public class Triangle {

	
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	int len = triangle.size();
    	if(len == 1)
    		return triangle.get(0).get(0);
        Integer[] val = new Integer[len];
        ArrayList<Integer> lastLine = triangle.get(len-1);
        val = lastLine.toArray(new Integer[len-1]);
        
        for(int i = len-2; i >= 0; i--){
        	ArrayList<Integer> line = triangle.get(i);
        	for(int j = 0; j <= i; j++){
        		int v = line.get(j);
        		val[j] = v + Math.min( val[j], val[j+1]);
        	}
        }
        
        return val[0];        
    }
    
    public static void main(String args[]){
    	ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> line1 = new ArrayList<Integer>();
    	line1.add(1);
    	ArrayList<Integer> line2 = new ArrayList<Integer>();
    	line2.add(2);
    	line2.add(3);
    	triangle.add(line1);
    	triangle.add(line2);
    	
    	System.out.println(new Triangle().minimumTotal(triangle));
    }
	
}
