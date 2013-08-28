package com.kodehawa.ce.forge.common;

import java.util.logging.Level;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import org.apache.commons.lang3.StringUtils;

import com.kodehawa.ce.CheatingEssentials;
import com.kodehawa.ce.event.events.EventRender3D;
import com.kodehawa.ce.forge.tick.TickHandler;
import com.kodehawa.ce.module.handlers.ModuleManager;
import com.kodehawa.ce.module.loader.BaseLoader;
import com.kodehawa.ce.playerrelations.Enemy;
import com.kodehawa.ce.playerrelations.Friend;
import com.kodehawa.ce.util.FileManager;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * These little lines of this are enough to init all the mod <3
 * Forge CE version main class, with all of my love for Optifine users. Me included :)
 * @author Kodehawa
 */

@Mod(modid="Cheating-Essentials", name="Cheating Essentials", version="3.2.1", useMetadata=true) //Gets mod data
@NetworkMod(clientSideRequired=true, serverSideRequired=false) 
@SideOnly(Side.CLIENT)
//I don't like this to be loaded in a server envirioment. It works in servers, but it can't be installed in servers.

public class Loader {
	
	public CheatingEssentials ce;
    public static TickHandler tickHandler = new TickHandler();
    private static final int MAJOR_VERSION = 3;
    private static final int MINOR_VERSION = 2;
    private static final int REVISION_VERSION = 1;
	
    @Instance("Cheating-Essentials")
    public static Loader instance;
   
    @SidedProxy(clientSide="com.kodehawa.ce.forge.common.ClientProxy", serverSide="com.kodehawa.ce.forge.common.CommonProxy")
    public static CommonProxy proxyHandler;
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	FMLLog.log("Cheating Essentials", Level.INFO, "Attempting a early Cheating Essentials initialization");
    	ce = new CheatingEssentials( );
    	FMLLog.log("Cheating Essentials", Level.INFO,
    			"Cheating Essentials Forge Loader: " + StringUtils.defaultString(Loader.class.getName()) +
    			" in Minecraft Forge " + ForgeVersion.getVersion());
    	FMLLog.log("Cheating Essentials", Level.INFO, "Loading mod instances...");
        initializeSingletons();
    	TickRegistry.registerScheduledTickHandler(tickHandler, Side.CLIENT);
    	FMLLog.log("Cheating Essentials", Level.INFO,
    			"Started Cheating Essentials "+getForgeCEVersion()+" in Minecraft 1.6.2 with Minecraft Forge " + ForgeVersion.getVersion());
    }
   
    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxyHandler.registerRenderers();
        MinecraftForge.EVENT_BUS.register(this);
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

	@ForgeSubscribe
	public void onRenderWorldLastEvent(RenderWorldLastEvent e){
		com.kodehawa.ce.event.EventHandler.getInstance().call(new EventRender3D(this));
	}
	
    @ForgeSubscribe
	public void renderOverlay(RenderGameOverlayEvent event){
		//TickHandler.instance().startGuiRendering();
	}
	
	private void initializeSingletons(){
        ModuleManager.getInstance();
        BaseLoader.getInstance();
        Enemy.getInstance();
        Friend.getInstance();
        FileManager.getInstance();
    }
	
	public static String getForgeCEVersion(){
		return MAJOR_VERSION+"."+MINOR_VERSION+"."+REVISION_VERSION; //Return current version
	}
}