package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Fly extends Mod {

	public static float FLY_SPEED = 0.05F;
	
	public Fly()
	{
		this.setCategory(ModuleCategories.PLAYER);
		this.setKeybinding(Keyboard.KEY_R);
	}
	
	@Override
	public String getName(){
		return "Fly";
	}
	
	@Override
	public String getDescription(){
		return "I believe I can fly (8)~";
	}

	public void onEnableMod(){
		Minecraft.getMinecraft().thePlayer.capabilities.setFlySpeed(FLY_SPEED);
		Wrapper.INSTANCE.player().capabilities.isFlying = true;
	}
	
	public void onDisableMod(){
		Wrapper.INSTANCE.player().capabilities.isFlying = false;
	}

	public void onTick(){
		Wrapper.INSTANCE.player().capabilities.isFlying = true;
	}
}
