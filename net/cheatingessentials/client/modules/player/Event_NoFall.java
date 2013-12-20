package net.cheatingessentials.client.modules.player;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.*;

public class Event_NoFall extends Module {

	public Event_NoFall() {
		super(Category.PLAYER);
		this.setForgeEvent(true);
	}
	
	@Override
	public String getModuleName(){
		return "Event No Fall";
	}
	
	@Override
	public String showHelp(){
		return "Removes fall damage to ALL entities";
	}

	@ForgeSubscribe
	public void onEvent(LivingFallEvent evt){
		if(evt.isCancelable()){
			evt.setCanceled(true);
		}
	}
}
