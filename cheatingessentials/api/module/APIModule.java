package cheatingessentials.api.module;

import java.util.ArrayList;

public class APIModule 
{

	public volatile static APIModule INSTANCE = new APIModule();
	public ArrayList<Mod> mods = new ArrayList<Mod>();	
	public ArrayList<Mod> activeMods = new ArrayList<Mod>();	

	public void enable(Mod mod)
	{
		mods.add(mod);
	}
	
	public void disable(Mod mod)
	{
		mods.remove(mod);
	}
	
	public void addActive(Mod mod)
	{
		activeMods.add(mod);
	}
	
	public void removeActive(Mod mod)
	{
		activeMods.remove(mod);
	}
	
	public Mod call(Class<Mod> clazz)
	{
		try 
		{
			for(Mod mod : mods)
			{
				if(mod.getClass() == clazz)
				{
					return mod;
				}
			}
		} 
		catch (Exception e){}
		
		return null;
	}
	
}
