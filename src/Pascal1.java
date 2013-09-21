import java.util.ArrayList;


public class Pascal1 {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>(numRows);
    	if(0 == numRows){
    	} else {
    		ArrayList<Integer> firstLine = new ArrayList<Integer>();
    		firstLine.add(1);
    		array.add(firstLine);
    		ArrayList<Integer> lastLine = null;
			for(int i = 1; i < numRows; i++){
				ArrayList<Integer> line = new ArrayList<Integer>();
				line.add(1);
				for(int j = 1; j < i; j++){
					line.add(lastLine.get(j) + lastLine.get(j-1));
				}
				line.add(1);
				lastLine = line;
				array.add(line);
			}
    	}
    	return array;
    }
    
    private static void printLine(ArrayList<Integer> line){
    	for(Integer i : line){
    		System.out.print(i+" , ");
    	}
    	System.out.println();
    }
    
    private static void printList(ArrayList<ArrayList<Integer>> list){
    	for(ArrayList<Integer> line : list){
    		printLine(line);
    	}
    }
    
    public static void main(String args[]){
    	printList(new Pascal1().generate(5));
    }
	
}
