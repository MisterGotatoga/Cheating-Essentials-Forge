package common.reeszrbteam.ce.gui.click.windows;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.module.man.ModuleManager;
import common.reeszrbteam.ce.gui.click.elements.YAWWindow;

public class WindowWorld extends YAWWindow
{
	public WindowWorld()
	{
		super("World", 186, 14);
	}
	
	public YAWWindow init()
	{
		for(AbstractModule mod: ModuleManager.instance().avModules)
		{
			if(mod.getCategory() == Category.WORLD)
			{
				addButton(mod);
			}
		}
		return this;
	}
}