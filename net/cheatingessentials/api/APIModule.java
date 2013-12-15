package net.cheatingessentials.api;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class APIModule
{
	
	private static volatile APIModule instance = new APIModule();
	public List<Module> modules = Lists.newArrayList();
	
	private APIModule(){}
	
	public void addModuleToCE(Module module)
	{
		if(!modules.contains(module))
		{
			modules.add(module);
		}
	}
	
	public List getModules()
	{
		return Collections.unmodifiableList(modules);
	}
	
	public Module getModuleClass(Class class1)
    {
    	for(Module m1 : APIModule.instance().modules){
			if(m1.getClass().equals(class1)){
				return m1;
			}
		}
		return null;
    }
	
	public static APIModule instance()
	{
		return instance;
	}
}
