package net.cheatingessentials.client.modules.none;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.gui.reeszrbteam.YouAlwaysWinClickGui;

import org.lwjgl.input.Keyboard;

public class Gui extends Module {

	private int mode = 0;
	private YouAlwaysWinClickGui click = new YouAlwaysWinClickGui();;
	
	public Gui() 
	{
		super(Category.NONE);
		this.setKeybinding(Keyboard.KEY_G);
	}
	
	public String getModuleName()
	{
		return "Gui";
	}
	
	@Override
	public void enable()
	{
		minecraft().func_147108_a(click);
	}
	
	@Override
	public void disable()
	{
		minecraft().func_147108_a(click);
	}
}
