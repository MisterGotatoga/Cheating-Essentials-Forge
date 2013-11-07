package common.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.reeszrbteam.ce.gui.click.YouAlwaysWinClickGui;

public class Gui extends AbstractModule {

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
		minecraft().displayGuiScreen(click);
	}
	
	@Override
	public void disable()
	{
		minecraft().displayGuiScreen(click);
	}
}
