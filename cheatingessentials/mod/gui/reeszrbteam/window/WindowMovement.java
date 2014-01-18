package cheatingessentials.mod.gui.reeszrbteam.window;

import cheatingessentials.api.module.APICEMod;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.gui.reeszrbteam.element.YAWWindow;
import cheatingessentials.mod.wrapper.ModuleCategories;

public class WindowMovement extends YAWWindow
{
	public WindowMovement()
	{
		super("World", 210, 14);
	}
	
	public YAWWindow init()
	{
		for(Mod mod: APICEMod.INSTANCE.mods)
		{
			if(mod.getCategory() == ModuleCategories.MOVEMENT)
			{
				addButton(mod);
			}
		}
		return this;
	}
}
