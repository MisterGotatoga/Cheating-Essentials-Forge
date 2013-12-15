package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class InvisiblePlayer extends Module {

	public InvisiblePlayer() {
		super(Category.PLAYER);
		super.setTick(true);
	}

	@Override
	public String getModuleName(){
		return "Invisible Player";
	}

	@Override
	public String showHelp(){
		return "Makes the player... invisible :)";
	}
	
	@Override
	public void tick(){
		player().setInvisible(true);
	}
	
	public void disable(){
		player().setInvisible(false);
	}
}
