package net.cheatingessentials.client.modules.player;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;

public class AutoRespawn extends Module {

	public AutoRespawn() {
		super(Category.PLAYER);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Auto Respawn";
	}
	
	@Override
	public String showHelp(){
		return "Auto Respawn the player when dead.";
	}
	
	@Override
	public void tick(){
		if(player().isDead){
			player().respawnPlayer();
		}
	}

}
