package net.cheatingessentials.client.modules.general;

import java.util.List;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.none.Gui;

import com.google.common.collect.Lists;

public class ModuleManager {

	private static volatile ModuleManager instance = new ModuleManager();
	private String version = "4.2";
	public List<String> enabled = Lists.newArrayList();
	
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
