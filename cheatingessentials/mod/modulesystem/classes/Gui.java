package cheatingessentials.mod.modulesystem.classes;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.gui.reeszrbteam.YouAlwaysWinClickGui;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Gui extends Mod {

	public Gui()
	{
		super(ModuleCategories.NONE);
		this.setKeybinding(Keyboard.KEY_G);
	}
	
	private YouAlwaysWinClickGui click = new YouAlwaysWinClickGui();;
	
	public String getName()
	{
		return "Gui";
	}
	
	@Override
	public void toggle()
	{
		Wrapper.INSTANCE.minecraft().func_147108_a(click);
	}

}
