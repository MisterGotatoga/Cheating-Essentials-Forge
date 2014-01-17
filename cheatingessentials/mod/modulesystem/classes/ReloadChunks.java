package cheatingessentials.mod.modulesystem.classes;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class ReloadChunks extends Mod {


	@Override
	public String getName(){
		return "Reload Chunks";
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.MISC;
	}
	
	@Override
	public void onEnableMod(){
		Wrapper.INSTANCE.minecraft().renderGlobal.loadRenderers();
	}
}
