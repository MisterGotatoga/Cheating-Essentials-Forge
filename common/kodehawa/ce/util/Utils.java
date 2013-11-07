package common.kodehawa.ce.util;

import java.util.Collection;
import java.util.HashSet;

public class Utils {

	private static volatile Utils instance = new Utils();
	
	public void removeDupes(Collection list) 
    {
        HashSet set = new HashSet(list);
        list.clear();
        list.addAll(set);
    }
	
	public static Utils instance(){
		return instance;
	}
}
