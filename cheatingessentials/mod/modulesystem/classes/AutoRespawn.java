package cheatingessentials.mod.modulesystem.classes;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class AutoRespawn extends Mod
{

	public AutoRespawn()
	{
		this.setCategory(ModuleCategories.PLAYER);
	}
	
	@Override
	public String getName(){
		return "Auto Respawn";
	}
	
	@Override
	public String getDescription(){
		return "Auto Respawn the player when dead.";
	}
	
	@Override
	public void onTick(){
		if(Wrapper.INSTANCE.player().isDead){
			Wrapper.INSTANCE.player().respawnPlayer();
		}
	}

}
