package cheatingessentials.mod.modulesystem.classes;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class WaterWalk extends Mod {

	public WaterWalk()
	{
		this.setCategory(ModuleCategories.MOVEMENT);
		this.setKeybinding(Keyboard.KEY_J);
	}
	
	@Override
	public String getName(){
		return "Water Walk";
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
