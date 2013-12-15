package net.cheatingessentials.util;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

public class Keybinding {

	private volatile static Keybinding instance = new Keybinding();
	
	public Keybinding(){
		handle();
	}
	
	public void handle(){
		for(Module module : APIModule.instance().modules){
			if(checkKey(module.getKeybind())){
				module.toggle(); break;
			}
        }
	}
	
	public boolean checkKey(int i) {
		if (Minecraft.getMinecraft().currentScreen != null) {
			return false;
		}
		if (Keyboard.isKeyDown(i) != keyStates [i]) {
			return keyStates[i] = !keyStates[i];
		} else {
			return false;
		}
	}
	
	private boolean keyStates[] = new boolean[256];
	
	public static Keybinding instance(){
		return instance;
	}
}