package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;

import org.lwjgl.input.Keyboard;

public class Sprint extends Module {

	public Sprint() {
		super(Category.PLAYER);
		super.setTick(true);
		this.setKeybinding(Keyboard.KEY_H);
	}

	@Override
	public String getModuleName(){
		return "Sprint";
	}
	
	@Override
	public String showHelp(){
		return "Sprints automatically when you should be walking.";
	}
	
	@Override
	public void tick(){
		if(player().moveForward > 0){
			player().setSprinting(true);
		}
	}
}
