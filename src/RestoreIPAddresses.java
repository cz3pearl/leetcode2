import java.util.ArrayList;


public class RestoreIPAddresses {

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<ArrayList<String>> ipListList = restoreString(s, 3, 4);
        ArrayList<String> ret = new ArrayList<String>();
        for(ArrayList<String> ipList: ipListList){
        	StringBuilder sb = new StringBuilder();
        	int idx = 0;
        	boolean valid = true;
        	for(String str : ipList){
        		if(Integer.parseInt(str) > 255){
        			valid = false;
        			break;
        		}
        		if(idx < 3){
        			sb.append(str + ".");
        		} else {
        			sb.append(str);
        		}
        		idx++;
        	}
        	if(valid)
        		ret.add(sb.toString());
        }
        return ret;
    }
    
    private ArrayList<ArrayList<String>> restoreString(String s, int limit, int t){
    	ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
    	int len = s.length();
    	if(t > 0 && len > 0 && (len / limit) <= t){
    		char c = s.charAt(0);
			 
			if (1 == t) {
				if (len <= limit) {
					if (1 == len || c != '0') {
						ArrayList<String> list = new ArrayList<String>();
						list.add(s);
						ret.add(list);
					}
				}
			} else {
				if (c == '0') {
					ArrayList<String> base = new ArrayList<String>();
					base.add(s.substring(0, 1));
					ArrayList<ArrayList<String>> subList = restoreString(
							s.substring(1), limit, t - 1);
					for (ArrayList<String> list : subList) {
						ArrayList<String> baseClone = (ArrayList<String>) base
								.clone();
						baseClone.addAll(list);
						ret.add(baseClone);
					}
				} else {
					for (int i = 1; i <= limit && i < len; i++) {
						ArrayList<String> base = new ArrayList<String>();
						base.add(s.substring(0, i));
						ArrayList<ArrayList<String>> subList = restoreString(
								s.substring(i), limit, t - 1);
						for (ArrayList<String> list : subList) {
							ArrayList<String> baseClone = (ArrayList<String>) base
									.clone();
							baseClone.addAll(list);
							ret.add(baseClone);
						}
					}
				}
			}
			
    	}
    	return ret;    	
    }
    
    public static void main(String args[]){
    	String s = "99999999";
    	RestoreIPAddresses ripAddress = new RestoreIPAddresses();
    	ArrayList<String> list = ripAddress.restoreIpAddresses(s);
    	for(String str : list){
    		System.out.println(str);
    	}
    }
}
