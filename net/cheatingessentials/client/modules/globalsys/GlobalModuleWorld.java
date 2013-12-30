package net.cheatingessentials.client.modules.globalsys;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.main.DynamicLogger;

import org.apache.logging.log4j.Level;


public class GlobalModuleWorld extends GlobalModule
{

	public GlobalModuleWorld() 
	{
		super("World", "Pure Cheating", 5.61, true, true);
	}
	
	private String worldPackageName;
	private String[] worldModuleClasses;

	@Override
	public void onGMInit()
	{
		preLoadWorldModules("net.cheatingessentials.client.modules.world");
	}
	
	@Override
	public void loadSubModules() 
	{
		for(int i = 0; i < worldModuleClasses.length; ++i){
			try 
			{
				Class clazz = Class.forName(worldPackageName+"."+worldModuleClasses[i]);
				if(clazz.getSuperclass() == Module.class)
				{
					Module instance = (Module) clazz.newInstance();
					APIModule.instance().addModuleToCE(instance);
				}
				else
				{
					DynamicLogger.instance().writeLog("Not recognized world module", Level.INFO);
				}
			} 
			catch (Exception e)
			{
				DynamicLogger.instance().writeLog("Unable to load world module: "+e, Level.WARN);
				e.printStackTrace();
			}
		}
	}

	private void preLoadWorldModules(String packageName)
	{
		worldPackageName = packageName;
		String[] moduleClasses = new String[]
		{
				"FastPlace", "Fullbright", "FastBreak", "NoWeb", "Day", "XRay", "MobAura"
		};
		
		worldModuleClasses = moduleClasses;
	}
}
