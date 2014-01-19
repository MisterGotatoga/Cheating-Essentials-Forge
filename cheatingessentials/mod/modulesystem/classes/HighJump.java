package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class HighJump extends Mod {
	
	public HighJump()
	{
		super(ModuleCategories.MOVEMENT);
	}
	
	@Override
	public String getName(){
		return "High Jump";
	}
	
	@Override
	public String getDescription(){
		return "Jump higher!";
	}
	
	@Override
	public void onEnableMod(){
		Wrapper.INSTANCE.player().addPotionEffect(new PotionEffect(Potion.jump.getId(), 9999999, 2));
	}
	
	@Override
	public void onDisableMod(){
		Wrapper.INSTANCE.player().removePotionEffect(Potion.jump.getId());
	}
}
