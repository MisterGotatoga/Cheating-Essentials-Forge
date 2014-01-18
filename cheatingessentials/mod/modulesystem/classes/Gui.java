package cheatingessentials.mod.modulesystem.classes;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.gui.reeszrbteam.YouAlwaysWinClickGui;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Gui extends Mod {

	private int mode = 0;
	private YouAlwaysWinClickGui click = new YouAlwaysWinClickGui();;
	
	public String getName()
	{
		return "Gui";
	}
	
	public int getKeybind()
	{
		return Keyboard.KEY_G;
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.NONE;
	}
	
	@Override
	public void toggle()
	{
		Wrapper.INSTANCE.minecraft().func_147108_a(click);
	}

}
