import java.util.ArrayList;

import org.junit.Test;


public class SimplifyPath {
    public String simplifyPath(String path) {
        ArrayList<String> pathList = new ArrayList<String>();
        String[] seps = path.split("/");
        for(String sep: seps){
            if(sep.equals(".") || "".equals(sep)){
            } else if (sep.equals("..")){
                if(pathList.size()>0)
                    pathList.remove(pathList.size()-1);
            } else {
                pathList.add(sep);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String sep : pathList){
            sb.append("/");
            sb.append(sep);
        }
        String result = sb.toString();
        if("".equals(result)){
            return "/";
        } else {
            return result;
        }
    }
    
    @Test
    public void test(){
    	System.out.println(simplifyPath("/home/"));
    	System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
