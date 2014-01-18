package cheatingessentials.mod.gui.reeszrbteam.window;

import cheatingessentials.api.module.APICEMod;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.gui.reeszrbteam.element.YAWWindow;
import cheatingessentials.mod.wrapper.ModuleCategories;

public class WindowUtils extends YAWWindow {

	public WindowUtils() {
		super("Misc", 113, 206);
	}
	
	public YAWWindow init()
	{
		for(Mod mod: APICEMod.INSTANCE.mods)
		{
			if(mod.getCategory() == ModuleCategories.MISC)
			{
				addButton(mod);
			}
		}
		return this;
	}

}
