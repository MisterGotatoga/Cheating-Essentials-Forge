package cheatingessentials.mod.gui.reeszrbteam.window;

import cheatingessentials.api.module.APICEMod;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.gui.reeszrbteam.element.YAWWindow;
import cheatingessentials.mod.wrapper.ModuleCategories;

public class WindowPlayer extends YAWWindow
{
	public WindowPlayer()
	{
		super("Player", 94, 14);
	}
	
	public YAWWindow init()
	{
		for(Mod mod: APICEMod.INSTANCE.mods)
		{
			if(mod.getCategory() == ModuleCategories.PLAYER)
			{
				addButton(mod);
			}
		}
		return this;
	}
}