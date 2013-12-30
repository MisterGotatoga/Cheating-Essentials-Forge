package net.cheatingessentials.client.modules.globalsys;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.main.DynamicLogger;

import org.apache.logging.log4j.Level;


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
				DynamicLogger.instance().writeLog("Unable to load render module: "+e, Level.WARN);
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
