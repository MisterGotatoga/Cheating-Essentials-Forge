package net.cheatingessentials.client.modules.globalsys;

import java.util.logging.Level;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.cheatingessentials.main.DynamicLogger;

public class GlobalModulePlayer extends GlobalModule {

	public GlobalModulePlayer() 
	{
		super("Player", "Pure Cheating", 5.61, true, true);
	}
	
	private String[] playerModuleClasses;
	private String playerPackageName;

	@Override
	public void onGMInit()
	{
		preLoadPlayerModules("net.cheatingessentials.client.modules.player");
	}
	
	@Override
	public void loadSubModules() 
	{
		for(int i = 0; i < playerModuleClasses.length; ++i){
			try 
			{
				Class clazz = Class.forName(playerPackageName+"."+playerModuleClasses[i]);
				if(clazz.getSuperclass() == Module.class)
				{
					Module instance = (Module) clazz.newInstance();
					APIModule.instance().addModuleToCE(instance);
				}
			}
			catch(Exception e){}
		}
	}

	private void preLoadPlayerModules(String packageName)
	{
		playerPackageName = packageName;
		String[] moduleClasses = new String[]
		{
				"Fly", "Speed", "DynamicFly", "HighJump", "Sprint", "Step", "WaterWalk", "Event_NoFall", "NoFall",
				"CreativeFly", "InvisiblePlayer", "Sneak", "AutoSprint", "Walk", "Unpushable", "DieCoordinates",
				"AutoRespawn"
		};
		
		playerModuleClasses = moduleClasses;
	}
}
