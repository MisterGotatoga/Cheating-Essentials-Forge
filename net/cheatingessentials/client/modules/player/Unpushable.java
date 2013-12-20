package net.cheatingessentials.client.modules.player;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;

public class Unpushable extends Module {

	public Unpushable() {
		super(Category.PLAYER);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Unpushable";
	}
	
	@Override
	public String showHelp(){
		return "No more knockback! :)";
	}
	
	@Override
	public void tick(){
		if(player().hurtResistantTime > 0 && player().hurtTime > 0){
			player().motionX = 0;
			player().motionZ = 0;
		}
	}

}
