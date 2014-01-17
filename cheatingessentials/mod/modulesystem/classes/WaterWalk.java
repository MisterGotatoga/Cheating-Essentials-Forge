package cheatingessentials.mod.modulesystem.classes;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class WaterWalk extends Mod {

	@Override
	public String getName(){
		return "Water Walk";
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.MOVEMENT;
	}

	public int getKeybind()
	{
		return Keyboard.KEY_J;
	}
	
	public boolean tick()
	{
		return true;
	}
	
	@Override
	public String getDescription(){
		return "I'm jesus!";
	}
	
	@Override
	public void onTick(){
		if(Wrapper.INSTANCE.player().isInWater()){
			Wrapper.INSTANCE.player().jump();
		}
	}
}
