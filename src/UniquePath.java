
public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] attach = new int[m+1][n+1];
        for(int i = 0; i <=m; i++){
        	for(int j = 0; j <=n; j++){
        		attach[i][j] = 0;
        	}
        }
        
        for(int i = m-1; i>=0; i--){
        	for(int j = n-1; j>=0; j--){
        		if(i == m-1 && j == n-1){
        			attach[i][j] = 1;
        		} else {
        			attach[i][j] = attach[i+1][j] + attach[i][j+1];
        		}
        	}
        }
        return attach[0][0];
    }
}
