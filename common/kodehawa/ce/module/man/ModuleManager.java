package common.kodehawa.ce.module.man;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import com.google.common.collect.Lists;

import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.module.classes.Console;
import common.kodehawa.ce.module.classes.Gui;
import common.kodehawa.ce.module.core.AbstractModule;

public class ModuleManager {

	private static volatile ModuleManager instance = new ModuleManager();
	private String version = "4.1";
	public List<AbstractModule> avModules = Lists.newArrayList();
	public List<String> enabled = Lists.newArrayList();

	public ModuleManager()
	{
		DynamicLogger.instance().writeLogWithPrefix("KMS", "Starting Kodehawa's Module System (KMS) ["+this+"] System on Cheating Essentials...", Level.INFO, 1);
		load("common.kodehawa.ce.module.classes."); //Package to load from.
	}

	private void load(String packageName)
	{
		String[] moduleClasses = new String[]{
				"Fly", "Speed", "DynamicFly", "FastPlace", "Fullbright", "HighJump", "Sprint", "FastBreak", "Step", "WaterWalk",
				"MCUtil_ReloadChunks", "AutoRespawn", "Event_NoFall", "NoFall", "CreativeFly", "ChestFinder", "InvisiblePlayer", 
				"NoWeb", "BlockFinder", "MCUtil_AdvancedTooltips", "Spectate", "Sneak", "AutoSprint", "Walk", 
				"Unpushable", "Day", "MCUtil_MobHitbox", "XRay", "MobAura", "Breadcrumb", "Tracers", "FreezeCam", "PlayerESP",
				"AnimalESP", "DieCoordinates" 
		};
		
		for(int i = 0; i < moduleClasses.length; ++i){
			try 
			{
				Class clazz = Class.forName(packageName+moduleClasses[i]);
				if(clazz.getSuperclass() == AbstractModule.class){
					AbstractModule instance = (AbstractModule) clazz.newInstance();
					addModule(instance);
				}
				else{
					DynamicLogger.instance().writeLog("Not recognized module", Level.INFO);
				}
			} catch (Exception e) {
				DynamicLogger.instance().writeLog("Can't load some module: "+e, Level.WARNING);
				e.printStackTrace();
			}
		}
	}
	
	private void addModule(AbstractModule module)
	{
		avModules.add(module);
	}
	
    public AbstractModule getModuleClass(Class class1)
    {
    	for(AbstractModule m1 : avModules){
			if(m1.getClass().equals(class1)){
				return m1;
			}
		}
		return null;
    }
    
    public String getModuleManagerVersion()
    {
    	return version;
    }
    
    public void addSpecialModules()
    {
		avModules.add(new Gui());
    }
    
    public List getModules()
    {
    	return Collections.unmodifiableList(avModules);
    }
	
    public String moduleInfo(AbstractModule module)
    {
    	return "name:"+module.getModuleName()+(" isForgeEvent:"+module.getForgeEvent()+" isTickable:"+module.getTick()+" isRenderable:"+module.getRender()+" isActive:"+module.isActive()).replaceAll(" ", ",");
    }
    
	public static ModuleManager instance()
	{
		return instance;
	}
}
