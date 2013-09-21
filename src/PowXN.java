
public class PowXN {
    public double pow(double x, int n) {
        double result = 1.0;
    	int e = Math.abs(n);
        if(e == 0)
        	return result;
        double t = x;
        while(e > 0){
        	result *=(e%2)==1?t:1;
        	t*=t;
        	e/=2;
        }
        if(n > 0)
        	return result;
        else
        	return 1/result;        
    }
}
