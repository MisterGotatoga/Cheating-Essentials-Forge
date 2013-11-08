package common.kodehawa.ce.util;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

import common.kodehawa.ce.event.EventHandler;
import common.kodehawa.ce.event.events.EventRender;
import common.kodehawa.reeszrbteam.ce.gui.click.YouAlwaysWinClickGui;
import common.kodehawa.reeszrbteam.ce.gui.click.elements.YAWWindow;

public class ForgeEvents {

	@ForgeSubscribe(priority=EventPriority.HIGHEST)
	public void onRenderWorldLastEvent(RenderWorldLastEvent evt){
		EventHandler.getInstance().call(new EventRender(this));
	}
	
	@ForgeSubscribe(priority=EventPriority.NORMAL)
	public void onRenderScreen(RenderGameOverlayEvent evt){
		for(YAWWindow windows : YouAlwaysWinClickGui.windows){
			if(windows.isPinned()){
				windows.draw(windows.getX(), windows.getY());
			}
		}
	}
}
