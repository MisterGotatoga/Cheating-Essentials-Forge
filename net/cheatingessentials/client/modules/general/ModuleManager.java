package net.cheatingessentials.client.modules.general;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.classes.Gui;
import net.cheatingessentials.main.DynamicLogger;

import com.google.common.collect.Lists;

public class ModuleManager {

	private static volatile ModuleManager instance = new ModuleManager();
	private String version = "4.1";
	public List<String> enabled = Lists.newArrayList();
	public String packageName = "";
	public String[] moduleClasses;

	public ModuleManager()
	{
		DynamicLogger.instance().writeLogWithPrefix("KMS", "Starting Kodehawa's Module System (KMS) ["+this+"] System on Cheating Essentials...", Level.INFO, 1);
		load("net.cheatingessentials.client.modules.classes."); //Package to load from.
	}

	private void load(String packageName)
	{
		this.packageName = packageName;
		String[] moduleClasses = new String[]
				{
				"Fly", "Speed", "DynamicFly", "FastPlace", "Fullbright", "HighJump", "Sprint", "FastBreak", "Step", "WaterWalk",
				"ReloadChunks", "AutoRespawn", "Event_NoFall", "NoFall", "CreativeFly", "ChestFinder", "InvisiblePlayer", 
				"NoWeb", "BlockFinder", "AdvancedTooltips", "Spectate", "Sneak", "AutoSprint", "Walk", 
				"Unpushable", "Day", "MobHitbox", "XRay", "MobAura", "Breadcrumb", "Tracers", "FreezeCam", "PlayerESP",
				"AnimalESP", "DieCoordinates" 
		};
		
		this.moduleClasses = moduleClasses;
	}
	
    public String getModuleManagerVersion()
    {
    	return version;
    }
    
    public void addSpecialModules()
    {
    	APIModule.instance().addModuleToCE(new Gui());
    }
    
    public String moduleInfo(Module module)
    {
    	return "name:"+module.getModuleName()+(" isForgeEvent:"+module.getForgeEvent()+" isTickable:"+module.getTick()+" isRenderable:"+module.getRender()+" isActive:"+module.isActive()).replaceAll(" ", ",");
    }
    
	public static ModuleManager instance()
	{
		return instance;
	}
}
