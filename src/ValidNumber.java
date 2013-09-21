
public class ValidNumber {

    public boolean isNumber(String s) {
    	s = s.trim();
    	int len = s.length();
    	int eIdx = s.indexOf('e');
    	if(eIdx > 0){
    		if(eIdx != len-1){
    			return isFloat(s, 0, eIdx) && isInt(s, eIdx+1, len); 
    		} else {
    			return false;
    		}
    	} else {
    		return isFloat(s, 0, len);
    	}        
    }
    
    public boolean isFloat(String s, int idxStart, int idxEnd){

    	if(s.startsWith("+.") || s.startsWith("-.")){
    		return isAllInt(s, idxStart+2, idxEnd);
    	}
    	
    	int pointIdx = s.indexOf('.', idxStart);
    	if(pointIdx >= 0){
    		if(idxStart == pointIdx)
    			return isAllInt(s, idxStart+1, idxEnd);
    		else if(pointIdx == idxEnd -1)
    			return isInt(s, idxStart, pointIdx);
    		else
    			return isInt(s, idxStart, pointIdx) && isAllInt(s, pointIdx+1, idxEnd);
    	} else {
    		return isInt(s, idxStart, idxEnd);
    	}
    	
    }

    public boolean isInt(String s, int idxStart, int idxEnd){
    	if(idxStart >= idxEnd)
    		return false;
    	if("".equals(s))
    		return false;
    	char cHead = s.charAt(idxStart);
    	if(cHead == '+' || cHead == '-')
    		return isAllInt(s, idxStart+1, idxEnd);
    	else
    		return isAllInt(s, idxStart, idxEnd);
    }
    
    public boolean isAllInt(String s, int idxStart, int idxEnd){
    	if(idxStart >= idxEnd)
    		return false;
    	for(int i = idxStart; i < idxEnd; i++){
    		char c = s.charAt(i);
    		if(c > '9' || c < '0'){
    			return false;
    		}
    	}
    	return true;
    }

    
}
