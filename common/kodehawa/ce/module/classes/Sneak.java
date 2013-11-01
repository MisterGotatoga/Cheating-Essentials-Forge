package common.kodehawa.ce.module.classes;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class Sneak extends AbstractModule {

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
		minecraft.gameSettings.keyBindSneak.pressed = true;
	}
	
	public void disable(){
		minecraft.gameSettings.keyBindSneak.pressed = false;
	}
}
