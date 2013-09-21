import java.util.ArrayList;


public class Pascal2 {
	
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>();
    	row.add(1);
    	if(rowIndex > 0){
    		for(int i = 1; i <= rowIndex; i++){
    			for(int j = i-1; j > 0; j--){
    				row.set(j, row.get(j) + row.get(j-1));
    			}
    			row.add(1);
    		}
    	}
    	return row;        
    }
    
    private static void printLine(ArrayList<Integer> line){
    	for(Integer i : line){
    		System.out.print(i+" , ");
    	}
    	System.out.println();
    }
    
    public static void main(String args[]){
    	printLine(new Pascal2().getRow(3));
    }
}
