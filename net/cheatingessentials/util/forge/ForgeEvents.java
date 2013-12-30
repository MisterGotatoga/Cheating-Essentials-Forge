package net.cheatingessentials.util.forge;

import net.cheatingessentials.client.event.EventHandler;
import net.cheatingessentials.client.event.EventRender;
import net.cheatingessentials.client.event.EventTick;
import net.cheatingessentials.gui.reeszrbteam.YouAlwaysWinClickGui;
import net.cheatingessentials.gui.reeszrbteam.element.YAWWindow;
import net.cheatingessentials.util.Keybinding;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class ForgeEvents {

	@SubscribeEvent
	public void onRenderWorldLastEvent(RenderWorldLastEvent evt){
		EventHandler.getInstance().call(new EventRender(this));
		System.out.println("Render: this is called");
	}
	
	@SubscribeEvent
	public void onRenderScreen(RenderGameOverlayEvent evt){
		for(YAWWindow windows : YouAlwaysWinClickGui.windows){
			if(windows.isPinned()){
				windows.draw(0, 0);
			}
		}
	}
	
	@SubscribeEvent
	public void tick(TickEvent evt)
	{
		Keybinding.instance().handle();
		if(FMLClientHandler.instance().getClient().theWorld != null && FMLClientHandler.instance().getClient().thePlayer != null ){
			EventHandler.getInstance().call(new EventTick(this));
		}
		//Isn't called LOL.
		System.out.println("Tick: this is called");
	}
}
