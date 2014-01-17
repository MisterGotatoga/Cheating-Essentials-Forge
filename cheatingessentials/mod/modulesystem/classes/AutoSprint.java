package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.oredict.RecipeSorter.Category;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class AutoSprint extends Mod {

	@Override
	public String getName(){
		return "Auto Sprint";
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.MOVEMENT;
	}
	
	@Override
	public String getDescription(){
		return "Makes the player sprint automatically (And walk too)";
	}
	
	@Override
	public void onTick(){
		KeyBinding.setKeyBindState(Wrapper.INSTANCE.minecraft().gameSettings.keyBindForward.func_151463_i(), true);
		Wrapper.INSTANCE.player().setSprinting(true);
	}
	
	public void onDisableMod()
	{
		KeyBinding.setKeyBindState(Wrapper.INSTANCE.minecraft().gameSettings.keyBindForward.func_151463_i(), false);
		Wrapper.INSTANCE.player().setSprinting(false);
	}
}
