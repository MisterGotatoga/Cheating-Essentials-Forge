package cheatingessentials.mod.modulesystem.classes;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;

public class Gui extends Mod {

	private int mode = 0;
	//private YouAlwaysWinClickGui click = new YouAlwaysWinClickGui();;
	
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
		//Wrapper.INSTANCE.minecraft().displayGuiScreen(click);
	}

}
