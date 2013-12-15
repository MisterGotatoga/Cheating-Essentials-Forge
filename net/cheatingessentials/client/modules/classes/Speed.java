package net.cheatingessentials.client.modules.classes;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.achievement.GuiAchievement;

public class Speed extends Module {

	public Speed()
	{
		super(Category.PLAYER);
		setTick(true);
	}
	
	public String getModuleName()
	{
		return "Speed";
	}
	
	@Override
	public String showHelp()
	{
		return "Makes the player to run faster.";
	}
	
	public static double SPEED_VALUE = 1.4;
	
	public void tick()
	{
		if(player().onGround && !minecraft().gameSettings.keyBindJump.pressed && minecraft().gameSettings.keyBindForward.pressed 
				&& !(minecraft().currentScreen instanceof GuiIngameMenu))
		{
			player().motionX *= SPEED_VALUE;
			player().motionZ *= SPEED_VALUE;
		}
	}
}
