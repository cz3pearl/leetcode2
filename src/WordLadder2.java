import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class WordLadder2 {

    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
        if(start.length() == 1 || isOneCharDiff(start, end)){
        	 ArrayList<String> resultOne = new ArrayList<String>();
        	 resultOne.add(start);
        	 resultOne.add(end);
        	 resultList.add(resultOne);
        	 return resultList;
        } else {
        	return findWordLadder(start, end, dict);
        }
    }
    
    private ArrayList<ArrayList<String>> findWordLadder(String start, String end, HashSet<String> dict){
    	Map<String, Set<String>> parentMap = new HashMap<String, Set<String>>(dict.size());
    	Set<String> triedSet = new HashSet<String>(dict.size());
//    	Map<String, Set<String>> idxDicMap = generateIdxDic(dict);
//    	Set<String> downSet = findOneStepChangeWord(start, idxDicMap);
    	Set<String> downSet = findOneStepChangeWord(start, dict);
    	for(String str : downSet){
    		Set<String> set = new HashSet<String>();
    		set.add(start);
    		parentMap.put(str,set);
    		triedSet.add(str);
    	}
//    	Set<String> endSet = findOneStepChangeWord(end, dict);
//    	Map<String,Set<String>> oneStepChangeSet = new HashMap<String,Set<String>>();
//    	oneStepChangeSet.put(end, endSet);
//    	oneStepChangeSet.put(start, downSet);
//    	Set<String> interSet = interSet(downSet,endSet);
    	boolean done = false;
    	if(downSet.contains(end))
    		done = true;
    	while(!done){
    		Set<String> nowTrieWords = new HashSet<String>();
    		for(String str : downSet){
//    			Set<String> oneStepChangeWords = oneStepChangeSet.get(str);
//    			if(null == oneStepChangeWords){
    			Set<String>	oneStepChangeWords = findOneStepChangeWord(str, dict);
//    				oneStepChangeSet.put(str, oneStepChangeWords);
//    			}
    			for(String word : oneStepChangeWords){
    				if(!triedSet.contains(word)){
    					nowTrieWords.add(word);
    					Set<String> set = parentMap.get(word);
    					if(null != set){
    						set.add(str);
    					} else {
    						set = new HashSet<String>();
    						set.add(str);
    						parentMap.put(word, set);
    					}
    					if(word.equals(end)){
    						done = true;
    					}
    				}
    			}
    		}
    		if(!done)
    			triedSet.addAll(nowTrieWords);

    		if(nowTrieWords.size() > 0){
    			downSet = nowTrieWords;
    		} else {
    			break;
    		}
    	}

    	ArrayList<ArrayList<String>> result = new  ArrayList<ArrayList<String>>();
    	ArrayList<String> baseList = new ArrayList<String>();
    	baseList.add(end);
    	parentMap.remove(start);
    	ArrayList<ArrayList<String>> tResult = getRoutes(baseList,end, parentMap);
    	for(ArrayList<String> tList : tResult){
    		ArrayList<String> list = new ArrayList<String>();
    		int len = tList.size();
    		for(int i = len-1; i >=0; i--){
    			list.add(tList.get(i));
    		}
    		result.add(list);    	
    	}
    	
    	return result;
    }
    
    private Set<String> findOneStepChangeWord(String word, HashSet<String> dict){
    	Set<String> ret = new HashSet<String>();
    	for(String dic : dict){
    		if(!word.equals(dic)){
    			if(isOneCharDiff(word, dic)){
    				ret.add(dic);
    			}
    		}
    	}
    	return ret;
    }
    

    
    private boolean isOneCharDiff(String word1, String word2){
    	int len1 = word1.length();
    	int len2 = word2.length();
    	if(len1!=len2){
    		return false;
    	} else {
    		int c = 0;
    		for(int i = 0; i < len1; i++){
    			if(word1.charAt(i)!= word2.charAt(i)){
    				c++;
    			}
    		}
    		
    		if(c < 2)
    			return true;
    		else
    			return false;
    	}
    }
    
    private String getIdxString(String word, int idx){
    	return word.charAt(idx)+"_"+idx;
    }
	
    private Set<String> interSet(Set<String> set1, Set<String> set2){
    	Set<String> t1 = set1;
    	Set<String> t2 = set2;
    	if(set1.size() > set2.size()){
	    	t1 = set2;
	    	t2 = set1;
    	}
    	
    	Set<String> resultSet = new HashSet<String>();
    	for(String str : t1){
    		if(t2.contains(str)){
    			resultSet.add(str);
    		}
    	}
    	return resultSet;    	
    }
    
    private ArrayList<ArrayList<String>> getRoutes(ArrayList<String> baseList, String end, Map<String,Set<String>> parentMap){
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    	Set<String> parents = parentMap.get(end);
    	if(null != parents){
    		for(String parent : parents){
	    		ArrayList<String> tList = (ArrayList<String>) baseList.clone();
	    		tList.add(parent);
	    		result.addAll(getRoutes(tList, parent, parentMap));
    		}
    	} else {
    		result.add(baseList);
    	}
    	return result;
    }
    
    public static void main(String args[]){
//    	"red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]
//    	["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]
//    	"cet", "ism", ["kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"]
    	String start = "cet";
    	String end = "ism";
    	String[] dicts = new String[]{"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
    	HashSet<String> dict = new HashSet<String>();
    	for(String word : dicts){
    		dict.add(word);
    	}
    	
    	WordLadder2 wl = new WordLadder2();
    	System.out.println(System.currentTimeMillis());
    	ArrayList<ArrayList<String>> result = wl.findLadders(start, end, dict);
    	System.out.println(System.currentTimeMillis());

    	for(ArrayList<String> list : result){
    		for(String str : list){
    			System.out.print(str+",");
    		}
    		System.out.println();
    	}
    }
}
