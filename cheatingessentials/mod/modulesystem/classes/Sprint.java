package cheatingessentials.mod.modulesystem.classes;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Sprint extends Mod {

	public Sprint()
	{
		super(ModuleCategories.PLAYER);
	}
	
	@Override
	public String getName(){
		return "Sprint";
	}
	
	@Override
	public String getDescription(){
		return "Sprints automatically when you should be walking.";
	}
	
	@Override
	public void onTick(){
		if(Wrapper.INSTANCE.player().moveForward > 0){
			Wrapper.INSTANCE.player().setSprinting(true);
		}
	}
}
