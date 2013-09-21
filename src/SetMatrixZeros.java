import java.util.HashSet;
import java.util.Set;


public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int xLen = matrix.length;
        if(xLen > 0){
            int yLen = matrix[0].length;
            Set<Integer> xSet = new HashSet<Integer>();
            Set<Integer> ySet = new HashSet<Integer>();
            for(int i = 0; i < xLen; i++){
                for(int j = 0; j < yLen; j++){
                    if(0 == matrix[i][j]){
                        xSet.add(i);
                        ySet.add(j);
                    }
                }
            }
            
            for(int i = 0; i < xLen; i++){
                for(int j = 0; j < yLen; j++){
                    if(xSet.contains(i)|| ySet.contains(j)){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
