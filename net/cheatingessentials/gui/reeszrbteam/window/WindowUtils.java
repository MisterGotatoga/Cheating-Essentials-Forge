package net.cheatingessentials.gui.reeszrbteam.window;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.cheatingessentials.gui.reeszrbteam.element.YAWWindow;

public class WindowUtils extends YAWWindow {

	public WindowUtils() {
		super("Utils", 113, 206);
	}
	
	public YAWWindow init()
	{
		for(Module mod: APIModule.instance().modules)
		{
			if(mod.getCategory() == Category.UTILS)
			{
				addButton(mod);
			}
		}
		return this;
	}

}
