package net.cheatingessentials.util.forge;

import net.cheatingessentials.client.event.EventHandler;
import net.cheatingessentials.client.event.EventRender;
import net.cheatingessentials.gui.reeszrbteam.YouAlwaysWinClickGui;
import net.cheatingessentials.gui.reeszrbteam.element.YAWWindow;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class ForgeEvents {

	@ForgeSubscribe(priority=EventPriority.HIGHEST)
	public void onRenderWorldLastEvent(RenderWorldLastEvent evt){
		EventHandler.getInstance().call(new EventRender(this));
	}
	
	@ForgeSubscribe(priority=EventPriority.NORMAL)
	public void onRenderScreen(RenderGameOverlayEvent evt){
		for(YAWWindow windows : YouAlwaysWinClickGui.windows){
			if(windows.isPinned()){
				windows.draw(0, 0);
			}
		}
	}
}
