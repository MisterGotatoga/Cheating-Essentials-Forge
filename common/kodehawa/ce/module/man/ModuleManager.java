package common.kodehawa.ce.module.man;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;

import com.google.common.collect.Lists;

import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.module.classes.DynamicFly;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.util.ConfigManager;
import common.kodehawa.ce.util.IRenderable;
import common.kodehawa.ce.util.ITickable;

public class ModuleManager {

	private static volatile ModuleManager instance = new ModuleManager();
	public List<AbstractModule> avModules = Lists.newArrayList();
	public List<AbstractModule> enabled2 = Lists.newArrayList();
	public List<String> enabled = Lists.newArrayList();
	public List<ITickable> tick = Lists.newArrayList();
	public List<IRenderable> render = Lists.newArrayList();

	public ModuleManager(){
		load("common.kodehawa.ce.module.classes.");
		DynamicLogger.instance().writeLog("Added: "+avModules.size()+" modules to Cheating Essentials" , Level.INFO);
	}

	private void load(String packageName){
		String[] moduleClasses = new String[]{
				"Fly", "Speed", "DynamicFly", "FastPlace", "Fullbright", "HighJump", "Sprint", "FastBreak", "Step", "WaterWalk",
				"MCUtil_ReloadChunks", "AutoRespawn", "Event_NoFall", "NoFall", "CreativeFly", "ChestFinder", /*"InvisiblePlayer",*/ "NoWeb", "BlockFinder",
				"AnimalESP", /*"ArrowDodge",*/  "MCUtil_AdvancedTooltips", "Spectate", "Sneak", "AutoSprint", "Walk", "Unpushable", /*"InfiniteArrow",*/ "Day",
				"MCUtil_MobHitbox", "XRay", "Test", 
		};
		
		for(int i = 0; i < moduleClasses.length; ++i){
			try {
				Class clazz = Class.forName(packageName+moduleClasses[i]);
				if(clazz.getSuperclass() == AbstractModule.class){
					AbstractModule instance = (AbstractModule) clazz.newInstance();
					avModules.add(instance);
				}
				else{
					DynamicLogger.instance().writeLog("Not recognized module", Level.INFO);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
    public AbstractModule getModuleClass(Class class1){
    	for(AbstractModule m1 : avModules){
			if(m1.getClass().equals(class1)){
				return m1;
			}
		}
		return null;
    }
    
    public List getModules(){
    	return Collections.unmodifiableList(avModules);
    }
	
	public static ModuleManager instance(){
		return instance;
	}
}
