package cheatingessentials.mod.modulesystem.classes;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class CreativeFly extends Mod {

	public CreativeFly()
	{
		this.setCategory(ModuleCategories.PLAYER);
	}
	
	@Override
	public String getName(){
		return "Creative Fly";
	}
	
	@Override
	public String getDescription(){
		return "Fly like in creative mode!";
	}
	
	@Override
	public void onEnableMod(){
		Wrapper.INSTANCE.player().capabilities.allowFlying = true;
		Wrapper.INSTANCE.player().sendPlayerAbilities();
	}

	@Override
	public void onDisableMod(){
		Wrapper.INSTANCE.player().capabilities.allowFlying = false;
		Wrapper.INSTANCE.player().sendPlayerAbilities();
	}
}
