package cheatingessentials.mod.wrapper;

import net.minecraftforge.client.event.RenderWorldLastEvent;
import cheatingessentials.api.module.APIModule;
import cheatingessentials.api.module.Mod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

/**
 * Forge event subscriber
 * @author Kodehawa
 */

public class Events 
{
	
	/**
	 * Normal Tick
	 * @param event
	 */
	@SubscribeEvent
	public void onTick(TickEvent.ServerTickEvent event)
	{
		for(Mod mod : APIModule.INSTANCE.mods)
		{
			mod.onTick();
		}
	}
	
	/**
	 * Player Update tick. Faster than others
	 * @param event
	 */
	@SubscribeEvent
	public void onPlayerUpdate(TickEvent.PlayerTickEvent event)
	{
		for(Mod mod : APIModule.INSTANCE.mods)
		{
			mod.onPlayerUpdate();
		}
	}
	
	/**
	 * World Tick.
	 * @param event
	 */
	@SubscribeEvent
	public void onWorldUpdate(TickEvent.WorldTickEvent event)
	{
		for(Mod mod : APIModule.INSTANCE.mods)
		{
			mod.onWorldUpdate();
		}
	}
	
	/**
	 * This should draw shit when world is rendering.
	 * @param event
	 */
	@SubscribeEvent
	public void onRenderWorld(RenderWorldLastEvent event)
	{
		for(Mod mod : APIModule.INSTANCE.mods)
		{
			mod.onWorldRender();
		}
	}
}
