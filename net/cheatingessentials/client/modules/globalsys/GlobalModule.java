package net.cheatingessentials.client.modules.globalsys;

import net.cheatingessentials.main.DynamicLogger;

import org.apache.logging.log4j.Level;

public class GlobalModule
{
	private static volatile GlobalModule instance = new GlobalModule();
	private String nam, typ;
	private double version;
	private boolean allowsubm, canenable;
	
	public GlobalModule(String name, String type, double ver, boolean allowsubmodules, boolean enabled)
	{
		nam = name;
		typ = type;
		version = ver;
		allowsubm = allowsubmodules;
		canenable = enabled;
		init();
		DynamicLogger.instance().writeLogWithPrefix("GM", "Loaded Global Module: "+"["+this+"] "+name+" ("+type+"). Version: "+ver, Level.INFO, 1);
	} 
	
	private GlobalModule()
	{
		new GlobalModulePlayer();
		new GlobalModuleWorld();
		new GlobalModuleRender();
		new GlobalModuleUtils();
	}
	
	private void init()
	{
		DynamicLogger.instance().writeLogWithPrefix("GM", "Loading Global Module: "+nam, Level.INFO, 1);
		if(canenable)
		{
			onGMInit();
			if(allowsubm)
			{
				loadSubModules();
			}
		}
		DynamicLogger.instance().writeLogWithPrefix("GM", "Loaded GM "+nam, Level.INFO, 1);
	}
	
	public static GlobalModule initKGMS()
	{
		return instance;
	}

	public void onGMInit(){}
	public void loadSubModules(){}
}
