package net.cheatingessentials.client.modules.player;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;

public class DieCoordinates extends Module {

	public DieCoordinates() 
	{
		super(Category.PLAYER);
		super.setTick(true);
	}
	
	int countdown = 80;
		
	public String getModuleName()
	{
		return "Die Coordinates";
	}

	public String showHelp()
	{
		return "Show coordinates on chat when player dies.";
	}
	
	public void tick()
	{
		//System.out.println(countdown);
		if(player().isDead && countdown == 1)
		{
			countdown = (int) (8 * Math.random());
			player().sendChatMessage("[CE] Coordinates on player dead:"+" x:"+(int)player().posX+" y:"+(int)player().posY+" z:"+(int)player().posZ);
		}
		if(!player().isDead)
		{
			countdown = 1;
		}
	}
}
