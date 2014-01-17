package cheatingessentials.mod.modulesystem.classes;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Sneak extends Mod {
	
	@Override
	public String getName(){
		return "Sneak";
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.MOVEMENT;
	}
	
	@Override
	public String getDescription(){
		return "Makes the player to sneak automatically";
	}

	public void onPlayerUpdate(){
		Wrapper.INSTANCE.player().setSneaking(true);
	}
	
	public void onDisableMod(){
		Wrapper.INSTANCE.player().setSneaking(false);
	}
}
