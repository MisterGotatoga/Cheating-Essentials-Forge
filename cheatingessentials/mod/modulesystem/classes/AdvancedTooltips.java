package cheatingessentials.mod.modulesystem.classes;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class AdvancedTooltips extends Mod {

	public ModuleCategories getCategory()
	{
		return ModuleCategories.MISC;
	}
	
	public String getName(){
		return "Advanced Tooltips";
	}

	public void onEnableMod(){
		Wrapper.INSTANCE.minecraft().gameSettings.advancedItemTooltips = !Wrapper.INSTANCE.minecraft().gameSettings.advancedItemTooltips;
	}
}
