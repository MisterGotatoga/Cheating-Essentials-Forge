package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.util.ReflectionHelper;
import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

public class FastPlace extends Module {

	public FastPlace() {
		super(Category.WORLD);
	    this.setTick(true);
		this.setKeybinding(Keyboard.KEY_K);
	}
	
	@Override
	public String getModuleName(){
		return "Fast Place";
	}
	
	@Override
	public String showHelp(){
		return "Makes the player to put blocks fastest than normal in the MC world";
	}

	@Override
	public void tick(){
		Object o = Minecraft.getMinecraft();
		ReflectionHelper.setField(Minecraft.class, o, 47 /*rightClickDelayTimer*/, 0);
	}
}
