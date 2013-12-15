package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;

public class Sneak extends Module {

	public Sneak() {
		super(Category.PLAYER);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Sneak";
	}
	
	@Override
	public String showHelp(){
		return "Makes the player to sneak automatically";
	}

	public void tick(){
		minecraft().gameSettings.keyBindSneak.pressed = true;
	}
	
	public void disable(){
		minecraft().gameSettings.keyBindSneak.pressed = false;
	}
}
