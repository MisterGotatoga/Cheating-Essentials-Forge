package cheatingessentials.mod.util;

import java.util.Collection;
import java.util.HashSet;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cheatingessentials.mod.wrapper.Wrapper;

public class CEUtility
{
	
	public static void removeDupes(Collection list) 
    {
        HashSet set = new HashSet(list);
        list.clear();
        list.addAll(set);
    }
}
