package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;

public class AdvancedTooltips extends Module {

	public AdvancedTooltips() {
		super(Category.UTILS);
	}
	
	public String getModuleName(){
		return "Advanced Tooltips";
	}

	public void enable(){
		minecraft().gameSettings.advancedItemTooltips = !minecraft().gameSettings.advancedItemTooltips;
	}
}
