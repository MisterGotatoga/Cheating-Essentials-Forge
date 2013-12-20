package net.cheatingessentials.client.modules.world;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.util.ReflectionHelper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;

import org.lwjgl.input.Keyboard;

public class NoWeb extends Module {

	public NoWeb() {
		super(Category.PLAYER);
		this.setTick(true);
		this.setKeybinding(Keyboard.KEY_NUMPAD5);
	}

	@Override
	public String getModuleName(){
		return "No Web";
	}
	
	@Override
	public String showHelp(){
		return "No more webs annoying you! Removes web slowdown";
	}
	
	@Override
	public void tick(){
		Object o = player();
		if(o instanceof EntityPlayerSP){
			ReflectionHelper.setField(Entity.class, o, 27, false);
		}
	}
}
