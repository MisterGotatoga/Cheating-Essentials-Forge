package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

public class Fly extends Module {

	public Fly() {
		super(Category.PLAYER);
		this.setTick(true);
		this.setKeybinding(Keyboard.KEY_R);
	}
	
	public static float FLY_SPEED = 0.05F;
	
	@Override
	public String getModuleName(){
		return "Fly";
	}
	
	@Override
	public String showHelp(){
		return "I believe I can fly (8)~";
	}

	public void enable(){
		Minecraft.getMinecraft().thePlayer.capabilities.setFlySpeed(FLY_SPEED);
		player().capabilities.isFlying = true;
	}
	
	public void disable(){
		player().capabilities.isFlying = false;
	}

	public void tick(){
		player().capabilities.isFlying = true;
	}
}
