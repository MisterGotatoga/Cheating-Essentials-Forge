package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Fly extends Mod {

	public static float FLY_SPEED = 0.05F;
	
	public int getKeybind()
	{
		return Keyboard.KEY_R;
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.PLAYER;
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
	
	public void disable(){
		Wrapper.INSTANCE.player().capabilities.isFlying = false;
	}

	public void tick(){
		Wrapper.INSTANCE.player().capabilities.isFlying = true;
	}
}
