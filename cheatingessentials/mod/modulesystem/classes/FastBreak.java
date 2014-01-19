package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class FastBreak extends Mod {

	public FastBreak()
	{
		this.setCategory(ModuleCategories.WORLD);
	}
	
	@Override
	public String getName(){
		return "Fast Break";
	}
	
	@Override
	public String getDescription(){
		return "Applies Haste III for help the player to break blocks faster. Works in MP";
	}
	
	@Override
	public void onEnableMod(){
		Wrapper.INSTANCE.player().addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 9999999));
	}
	
	@Override
	public void onDisableMod(){
		Wrapper.INSTANCE.player().removePotionEffect(Potion.digSpeed.getId());
	}
}
