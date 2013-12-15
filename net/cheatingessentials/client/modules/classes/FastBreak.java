package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class FastBreak extends Module {

	public FastBreak() {
		super(Category.WORLD);
	}
	
	@Override
	public String getModuleName(){
		return "Fast Break";
	}
	
	@Override
	public String showHelp(){
		return "Applies Haste III for help the player to break blocks faster. Works in MP";
	}
	
	@Override
	public void enable(){
		player().addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 9999999));
	}
	
	@Override
	public void disable(){
		player().removePotionEffect(Potion.digSpeed.getId());
	}
}
