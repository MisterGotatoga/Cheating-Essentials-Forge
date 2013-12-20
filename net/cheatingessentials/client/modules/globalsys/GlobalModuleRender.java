package net.cheatingessentials.client.modules.globalsys;

import java.util.logging.Level;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.cheatingessentials.main.DynamicLogger;

public class GlobalModuleRender extends GlobalModule 
{

	public GlobalModuleRender()
	{
		super("Render", "Renderizable", 5.61, true, true);
	}
	
	private String renderPackageName;
	private String[] renderModuleClasses;
	
	@Override
	public void onGMInit()
	{
		preLoadRenderModules("net.cheatingessentials.client.modules.render");
	}

	@Override
	public void loadSubModules() 
	{
		for(int i = 0; i < renderModuleClasses.length; ++i){
			try 
			{
				Class clazz = Class.forName(renderPackageName+"."+renderModuleClasses[i]);
				if(clazz.getSuperclass() == Module.class)
				{
					Module instance = (Module) clazz.newInstance();
				    APIModule.instance().addModuleToCE(instance);
				}
			} 
			catch (Exception e)
			{
				DynamicLogger.instance().writeLog("Unable to load render module: "+e, Level.WARNING);
				e.printStackTrace();
			}
		}
	}
	
	private void preLoadRenderModules(String packageName)
	{
		renderPackageName = packageName;
		String[] moduleClasses = new String[]
		{
				"ChestFinder", "BlockFinder", "Breadcrumb", "Tracers", "FreezeCam", "PlayerESP",
				/*"AnimalESP"*/
		};
		
		renderModuleClasses = moduleClasses;
	}

}
