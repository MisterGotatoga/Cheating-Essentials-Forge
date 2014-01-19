package cheatingessentials.mod.modulesystem.classes;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class DieCoordinates extends Mod
{
	int countdown = 80;
		
	public DieCoordinates()
	{
		this.setCategory(ModuleCategories.MISC);
	}
	
	public String getName()
	{
		return "Die Coordinates";
	}

	public String getDescription()
	{
		return "Show coordinates on chat when player dies.";
	}
	
	public void onTick()
	{
		if(Wrapper.INSTANCE.player().isDead && countdown == 1)
		{
			countdown = (int) (8 * Math.random());
			Wrapper.INSTANCE.addChatMessage("[CE] Coordinates on player dead:"+" x:"+(int)Wrapper.INSTANCE.player().posX+" y:"+(int)Wrapper.INSTANCE.player().posY+" z:"+(int)Wrapper.INSTANCE.player().posZ);
		}
		if(!Wrapper.INSTANCE.player().isDead)
		{
			countdown = 1;
		}
	}
}
