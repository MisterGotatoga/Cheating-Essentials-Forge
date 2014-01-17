package cheatingessentials.mod.modulesystem.classes;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Unpushable extends Mod {
	
	@Override
	public String getName(){
		return "Unpushable";
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.MOVEMENT;
	}
	
	@Override
	public String getDescription(){
		return "No more knockback! :)";
	}
	
	@Override
	public void onTick(){
		if(Wrapper.INSTANCE.player().hurtResistantTime > 0 && Wrapper.INSTANCE.player().hurtTime > 0){
			Wrapper.INSTANCE.player().motionX = 0;
			Wrapper.INSTANCE.player().motionZ = 0;
		}
	}

}
