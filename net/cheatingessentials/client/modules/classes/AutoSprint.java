package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;

public class AutoSprint extends Module {

	public AutoSprint() {
		super(Category.PLAYER);
		this.setTick(true);
	}

	@Override
	public String getModuleName(){
		return "Auto Sprint";
	}
	
	@Override
	public String showHelp(){
		return "Makes the player sprint automatically (And walk too)";
	}
	
	@Override
	public void tick(){
		minecraft().gameSettings.keyBindForward.pressed = true;
		player().setSprinting(true);
	}
}
