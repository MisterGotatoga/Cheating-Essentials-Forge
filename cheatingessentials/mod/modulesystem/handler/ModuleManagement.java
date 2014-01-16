package cheatingessentials.mod.modulesystem.handler;

import cheatingessentials.api.module.APIModule;
import cheatingessentials.mod.modulesystem.classes.StaticFly;

public class ModuleManagement 
{

	public volatile static ModuleManagement INSTANCE = new ModuleManagement();
	
	public void initModules()
	{
		APIModule.INSTANCE.enable(new StaticFly());
	}
}
