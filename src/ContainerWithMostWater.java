
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        int i = 0; 
        int j = len - 1;
        while(i < j){
        	int hI = height[i];
        	int hJ = height[j];
        	max = Math.max(max, Math.min(hI, hJ)*(j-i));
        	if(hI >= hJ){
        		j--;
        	} else {
        		i++;
        	}
        }
        return max;
    }
}
