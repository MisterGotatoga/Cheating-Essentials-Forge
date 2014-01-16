package cheatingessentials.mod.util;

import java.util.Collection;
import java.util.HashSet;

public class CEUtility
{
	
	public static void removeDupes(Collection list) 
    {
        HashSet set = new HashSet(list);
        list.clear();
        list.addAll(set);
    }

}
