package cheatingessentials.mod.wrapper;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderWorldLastEvent;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.APIModule;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.main.CheatingEssentials;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

/**
 * Forge event subscriber
 * @author Kodehawa
 */

public class Events 
{
	
	public Events()
	{
		CheatingEssentials.INSTANCE.logger.info("Forge events initialization.");
	}
	
	private int counter;
	
	/**
	 * Normal Tick
	 * @param event
	 */
	@SubscribeEvent
	public void onTick(TickEvent.ServerTickEvent event)
	{
		for(Mod mod : APIModule.INSTANCE.mods)
		{
			if(mod.isActive() && Wrapper.INSTANCE.world() != null)
			mod.onTick();
		}
	}
	
	
	
	@SubscribeEvent
	public void onCTick(TickEvent.ClientTickEvent event)
	{
		for(Mod mod : APIModule.INSTANCE.mods)
		{
			
			if(checkAndSaveKeyState(mod.getKeybind()) && Wrapper.INSTANCE.world() != null)
			{
				mod.toggle();
				break;
			}
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
			if(mod.isActive() && Wrapper.INSTANCE.world() != null)
			mod.onPlayerUpdate();
		}
		//Debugging: System.out.println("Is this called?");
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
			if(mod.isActive() && Wrapper.INSTANCE.world() != null)
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
			if(mod.isActive() && Wrapper.INSTANCE.world() != null)
			mod.onWorldRender();
		}
	}
	
	public boolean checkAndSaveKeyState(int key) {
		if (Wrapper.INSTANCE.minecraft().currentScreen != null) 
		{
			return false;
		}
		
		if (Keyboard.isKeyDown(key) != keyStates [key]) 
		{
			return keyStates[key] = !keyStates[key];
		} 
		
		else
		{
			return false;
		}
	}
	
	private boolean keyStates[] = new boolean[256];
	
}
