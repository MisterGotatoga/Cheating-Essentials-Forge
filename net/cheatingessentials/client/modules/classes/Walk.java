package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;

public class Walk extends Module {

	public Walk() {
		super(Category.PLAYER);
		this.setTick(true);
	}

	@Override
	public String getModuleName(){
		return "Auto Walk";
	}
	
	@Override
	public String showHelp(){
		return "Makes the player to walk automatically.";
	}
	
	public void tick(){
		minecraft().gameSettings.keyBindForward.pressed = true;
	}
	
	public void disable(){
		minecraft().gameSettings.keyBindForward.pressed = false;
	}
}
