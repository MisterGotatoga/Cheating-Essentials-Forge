package cheatingessentials.mod.modulesystem.classes;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Unpushable extends Mod {
	
	public Unpushable()
	{
		this.setCategory(ModuleCategories.PLAYER);
	}
	
	@Override
	public String getName(){
		return "Unpushable";
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
