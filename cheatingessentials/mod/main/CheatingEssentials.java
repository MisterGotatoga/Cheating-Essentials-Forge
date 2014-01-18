package cheatingessentials.mod.main;

import java.util.Arrays;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import cheatingessentials.api.module.APIModule;
import cheatingessentials.mod.commands.NCommandMT;
import cheatingessentials.mod.external.config.management.ConfigurationManager;
import cheatingessentials.mod.logger.CELogger;
import cheatingessentials.mod.modulesystem.handler.ModuleManagement;
import cheatingessentials.mod.screens.LoadingScreen;
import cheatingessentials.mod.wrapper.Events;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = "cheatingessentials", name = "Cheating Essentials", version = CheatingEssentials.version, canBeDeactivated = true)
public class CheatingEssentials
{

	@Instance("cheatingessentials")
	public static CheatingEssentials INSTANCE;
	public CELogger logger = new CELogger("Cheating Essentials");
	public final static String version = "7.0 Alpha 1";
	
	@EventHandler
	public void onPreInitialization(FMLPreInitializationEvent event1)
	{		
		logger.info("Adding metadata information...");
		ModMetadata mMetadata = event1.getModMetadata();
		mMetadata.credits = "Kodehawa";
		mMetadata.version = version;
		mMetadata.description = "Cheat anything you want, discover edges of Minecraft!";
		mMetadata.autogenerated = false;
		mMetadata.authorList = Arrays.asList("Kodehawa", "ReesZRB");
		mMetadata.url = "http://www.minecraftforum.net/topic/1846289-";		
		
		logger.info("Loading..."); 
		logger.info("Cheating Essentials 7 by Kodehawa loading in minecraft version " + MinecraftForge.MC_VERSION + " and Minecraft Forge "+MinecraftForge.getBrandingVersion());
		LoadingScreen.main = true;
	}
	
	@EventHandler
	public void onInitialization(FMLInitializationEvent event2)
	{
		LoadingScreen.main = false;
		logger.info("Loading Modules...");
		ModuleManagement.INSTANCE.initModules();
		LoadingScreen.module = true;
		logger.info(APIModule.INSTANCE.mods.size() + " Modules loaded succefully!");
		LoadingScreen.module = false;
		FMLCommonHandler.instance().bus().register(new Events());
		MinecraftForge.EVENT_BUS.register(new Events());
		logger.info("Loading Configuration...");
		LoadingScreen.config = true;
		ConfigurationManager.instance();
		logger.info("Configuration Loaded.");
	}
		
	public void onPostInitialization(FMLPostInitializationEvent event3)
	{
		logger.info("All things loaded succefully.");
		LoadingScreen.lastshit = true;
	}
	
	@EventHandler
	public void onServerStart(FMLServerStartingEvent event4)
	{		
		MinecraftServer minecraftserver = MinecraftServer.getServer();
		ICommandManager icommand = minecraftserver.getCommandManager();
		ServerCommandManager commandhandler = ((ServerCommandManager) icommand);
		
		commandhandler.registerCommand(new NCommandMT());
		logger.info("Natural Vanilla commands registered!");
	}
}
