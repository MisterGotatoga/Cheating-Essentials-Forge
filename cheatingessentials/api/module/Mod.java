package cheatingessentials.api.module;

import org.lwjgl.input.Keyboard;

import cheatingessentials.mod.wrapper.ModuleCategories;

public abstract class Mod 
{

	protected String name = "unknown";
	protected String description = "unknown";
	protected int keybind = Keyboard.KEY_NONE;
	protected boolean enabled;
	protected ModuleCategories category = ModuleCategories.MISC;

	public String getName()
	{
		return name;
	}
	
	public int getKeybind()
	{
		return keybind;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public ModuleCategories getCategory()
	{
		return category;
	}
	
	public boolean isActive()
	{
		return enabled;
	}
	
	public boolean playerUpdate()
	{
		return false;
	}
	
	public boolean worldUpdate()
	{
		return false;
	}
	
	public boolean worldRender()
	{
		return false;
	}
	
	public boolean tick()
	{
		return false;
	}
	
	public void onPlayerUpdate(){}
	public void onWorldUpdate(){}
	public void onTick(){}
	public void onWorldRender(){}
	public void onEnableMod(){}
	public void onDisableMod(){}
	
	/**
	 * Toggles the specified module
	 */
	public void toggle()
	{
		enabled = !enabled;
		
		if(isActive())
		{
			onEnableMod();
		}
		else
		{
			onDisableMod();
		}
	}
}
