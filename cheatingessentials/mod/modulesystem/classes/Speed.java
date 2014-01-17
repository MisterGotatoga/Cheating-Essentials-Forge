package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.client.gui.GuiIngameMenu;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Speed extends Mod {
		
	public String getName()
	{
		return "Speed";
	}
	
	@Override
	public String getDescription()
	{
		return "Makes the player to run faster.";
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.PLAYER;
	}
	
	public static double SPEED_VALUE = 1.4;
	
	int start = 0;
	int finish = 100;
	
	public void onTick()
	{
		if(Wrapper.INSTANCE.player().onGround && !Keyboard.isKeyDown(Wrapper.INSTANCE.minecraft().gameSettings.keyBindJump.func_151463_i()) && Keyboard.isKeyDown(Wrapper.INSTANCE.minecraft().gameSettings.keyBindForward.func_151463_i()) 
				&& !(Wrapper.INSTANCE.minecraft().currentScreen instanceof GuiIngameMenu))
		{
			Wrapper.INSTANCE.player().motionX *= SPEED_VALUE;
			Wrapper.INSTANCE.player().motionZ *= SPEED_VALUE;
		}
	}
}
