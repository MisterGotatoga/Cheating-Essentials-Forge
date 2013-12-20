package net.cheatingessentials.client.modules.player;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class HighJump extends Module {

	public HighJump() {
		super(Category.PLAYER);
	}
	
	@Override
	public String getModuleName(){
		return "High Jump";
	}
	
	@Override
	public String showHelp(){
		return "Jump higher!";
	}
	
	@Override
	public void enable(){
		player().addPotionEffect(new PotionEffect(Potion.jump.getId(), 9999999, 2));
	}
	
	@Override
	public void disable(){
		player().removePotionEffect(Potion.jump.getId());
	}
}
