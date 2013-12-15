package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;

public class CreativeFly extends Module {

	public CreativeFly() {
		super(Category.PLAYER);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Creative Fly";
	}
	
	@Override
	public String showHelp(){
		return "Fly like in creative mode!";
	}
	
	@Override
	public void enable(){
		player().capabilities.allowFlying = true;
		player().sendPlayerAbilities();
	}

	@Override
	public void disable(){
		player().capabilities.allowFlying = false;
		player().sendPlayerAbilities();
	}
}
