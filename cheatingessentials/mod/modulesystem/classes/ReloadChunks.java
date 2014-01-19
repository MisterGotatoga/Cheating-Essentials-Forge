package cheatingessentials.mod.modulesystem.classes;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class ReloadChunks extends Mod {

	public ReloadChunks()
	{
		super(ModuleCategories.MISC);
	}
	
	@Override
	public String getName(){
		return "Reload Chunks";
	}
	
	@Override
	public void onEnableMod(){
		Wrapper.INSTANCE.minecraft().renderGlobal.loadRenderers();
	}
}
