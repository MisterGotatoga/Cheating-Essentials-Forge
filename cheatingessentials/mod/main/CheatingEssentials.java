package cheatingessentials.mod.main;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import cheatingessentials.api.module.APIModule;
import cheatingessentials.mod.internal.FontRendering;
import cheatingessentials.mod.logger.CELogger;
import cheatingessentials.mod.modulesystem.handler.ModuleManagement;
import cheatingessentials.mod.wrapper.Wrapper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "cheatingessentials", name = "Cheating Essentials", version = CheatingEssentials.version, canBeDeactivated = true)
public class CheatingEssentials
{

	@Instance("cheatingessentials")
	public static CheatingEssentials INSTANCE;
	public CELogger logger = new CELogger("Cheating Essentials");
	public final static String version = "7.11.0";
	public FontRendering renderFont;
	
	@EventHandler
	public void onPreInitialization(FMLPreInitializationEvent event1)
	{
		logger.info("Loading..."); 
		logger.info("Cheating Essentials 7 by Kodehawa loading in minecraft version " + MinecraftForge.MC_VERSION + " and Minecraft Forge "+MinecraftForge.getBrandingVersion());
		logger.info("Attempting to implement TTF rendering...");
		renderFont = new FontRendering(Wrapper.INSTANCE.mcSettings(), new ResourceLocation("textures/font/ascii.png"), Wrapper.INSTANCE.minecraft().renderEngine, false);
		logger.info("Implemented TTF for internal mod rendering");
	}
	
	@EventHandler
	public void onInitialization(FMLInitializationEvent event2)
	{
		logger.info("Loading Modules...");
		ModuleManagement.INSTANCE.initModules();
		logger.info(APIModule.INSTANCE.mods.size() + " Modules loaded succefully!");
	}
	
	public void onPostInitialization(FMLPostInitializationEvent event3)
	{
		logger.info("All things loaded succefully.");
	}
}
