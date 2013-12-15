package net.cheatingessentials.client.modules.globalsys;

import java.util.logging.Level;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.cheatingessentials.main.DynamicLogger;

public class GlobalModuleUtils extends GlobalModule {

	public GlobalModuleUtils() 
	{
		super("Utils", "Utilities", 5.61, true, true);
	}

	@Override
	public void loadSubModules() 
	{
		for(int i = 0; i < ModuleManager.instance().moduleClasses.length; ++i){
			try 
			{
				Class clazz = Class.forName(ModuleManager.instance().packageName+ModuleManager.instance().moduleClasses[i]);
				if(clazz.getSuperclass() == Module.class)
				{
					Module instance = (Module) clazz.newInstance();
					if(instance.cat == Category.UTILS)
					{
						APIModule.instance().addModuleToCE(instance);
					}
				}
			} 
			catch (Exception e)
			{
				DynamicLogger.instance().writeLog("Unable to load util module: "+e, Level.WARNING);
				e.printStackTrace();
			}
		}
	}

}
