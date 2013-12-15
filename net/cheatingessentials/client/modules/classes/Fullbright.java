package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;

import org.lwjgl.input.Keyboard;

public class Fullbright extends Module {

	public Fullbright() {
		super(Category.WORLD);
		this.setKeybinding(Keyboard.KEY_F);
	}

	@Override
	public String getModuleName(){
		return "Fullbright";
	}
	
	@Override
	public String showHelp(){
		return "Makes the world brighter";
	}
	
	@Override
	public void enable(){
		float[] bright = world().provider.lightBrightnessTable;
		for(int i = 0; i < bright.length; i++){
			bright[i] = 1.0F;
		}
	}
	
	@Override
	public void disable(){
		world().provider.registerWorld(world());
	}
}
