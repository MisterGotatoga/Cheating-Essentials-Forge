package cheatingessentials.mod.modulesystem.classes;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Sprint extends Mod {

	@Override
	public String getName(){
		return "Sprint";
	}
	
	@Override
	public String getDescription(){
		return "Sprints automatically when you should be walking.";
	}
	
	public int getKeybind()
	{
		return Keyboard.KEY_H;
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.PLAYER;
	}
	
	@Override
	public void onTick(){
		if(Wrapper.INSTANCE.player().moveForward > 0){
			Wrapper.INSTANCE.player().setSprinting(true);
		}
	}
}
