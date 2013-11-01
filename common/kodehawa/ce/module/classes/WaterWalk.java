package common.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class WaterWalk extends AbstractModule {

	public WaterWalk() {
		super(Category.WORLD);
		this.setTick(true);
		this.setKeybinding(Keyboard.KEY_J);
	}

	@Override
	public String getModuleName(){
		return "Water Walk";
	}
	
	@Override
	public String showHelp(){
		return "I'm jesus!";
	}
	
	@Override
	public void tick(){
		if(player.isInWater()){
			minecraft.gameSettings.keyBindJump.pressed = true;
		}
	}
}
