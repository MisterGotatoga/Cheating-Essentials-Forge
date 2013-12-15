package net.cheatingessentials.gui.reeszrbteam.window;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.gui.reeszrbteam.element.YAWWindow;

public class WindowWorld extends YAWWindow
{
	public WindowWorld()
	{
		super("World", 186, 14);
	}
	
	public YAWWindow init()
	{
		for(Module mod: APIModule.instance().modules)
		{
			if(mod.getCategory() == Category.WORLD)
			{
				addButton(mod);
			}
		}
		return this;
	}
}