package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class DieCoordinates extends AbstractModule {

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
			player().addChatMessage("[CE] Coordinates on player dead:"+" x:"+(int)player().posX+" y:"+(int)player().posY+" z:"+(int)player().posZ);
		}
		if(!player().isDead)
		{
			countdown = 1;
		}
	}
}
