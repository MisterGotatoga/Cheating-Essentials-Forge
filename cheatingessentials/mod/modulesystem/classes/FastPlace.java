package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.util.reflect.ReflectionHelper;
import cheatingessentials.mod.wrapper.ModuleCategories;

public class FastPlace extends Mod {

	public int getKeybinding()
	{
		return Keyboard.KEY_K;
	}
		
	public ModuleCategories getCategory()
	{
		return ModuleCategories.WORLD;
	}
	
	@Override
	public String getName(){
		return "Fast Place";
	}
	
	@Override
	public String getDescription(){
		return "Makes the player to put blocks fastest than normal in the MC world";
	}

	@Override
	public void onTick(){
		Object o = Minecraft.getMinecraft();
		ReflectionHelper.setField(Minecraft.class, o, 46, 0);
	}
}
