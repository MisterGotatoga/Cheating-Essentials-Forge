package common.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import common.kodehawa.api.console.GuiConsole;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class Console extends AbstractModule {

	private GuiConsole console = new GuiConsole();
	
	public Console() 
	{
		super(Category.NONE);
		super.setKeybinding(Keyboard.KEY_U);
	}

	public String getModuleName(){
		return "Console";
	}
	
	public void enable()
	{
		minecraft().displayGuiScreen(console);
	}
	
	public void disable()
	{
		minecraft().displayGuiScreen(console);
	}
}
