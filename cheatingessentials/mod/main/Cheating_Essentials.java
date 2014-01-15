package cheatingessentials.mod.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "cheatingessentials", name = "Cheating Essentials", version = "7.11.25.915", canBeDeactivated = true)
public class Cheating_Essentials
{

	@Instance("cheatingessentials")
	public static Cheating_Essentials INSTANCE;
	
	@EventHandler
	public void onPreInitialization(FMLPreInitializationEvent event1)
	{
		
	}
}
