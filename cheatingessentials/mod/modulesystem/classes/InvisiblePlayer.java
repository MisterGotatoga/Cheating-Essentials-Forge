package cheatingessentials.mod.modulesystem.classes;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class InvisiblePlayer extends Mod {

	public InvisiblePlayer()
	{
		super(ModuleCategories.PLAYER);
	}
	
	@Override
	public String getName(){
		return "Invisible Player";
	}

	@Override
	public String getDescription(){
		return "Makes the player... invisible :)";
	}
	
	@Override
	public void onTick(){
		Wrapper.INSTANCE.player().setInvisible(true);
	}
	
	public void onDisableMod(){
		Wrapper.INSTANCE.player().setInvisible(false);
	}
}
