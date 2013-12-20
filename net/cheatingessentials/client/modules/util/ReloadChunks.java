package net.cheatingessentials.client.modules.util;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;

public class ReloadChunks extends Module {

	public ReloadChunks() {
		super(Category.UTILS);
	}

	@Override
	public String getModuleName(){
		return "Reload Chunks";
	}
	
	@Override
	public void enable(){
		minecraft().renderGlobal.loadRenderers();
	}
}
