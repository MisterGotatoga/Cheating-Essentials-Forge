package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;

import org.lwjgl.input.Keyboard;

public class WaterWalk extends Module {

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
		if(player().isInWater()){
			minecraft().gameSettings.keyBindJump.pressed = true;
		}
	}
}
