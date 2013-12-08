package common.reeszrbteam.ce.gui.click.windows;

import net.minecraft.client.Minecraft;

import common.kodehawa.ce.main.CheatingEssentials;
import common.reeszrbteam.ce.gui.click.elements.YAWButton;
import common.reeszrbteam.ce.gui.click.elements.YAWWindow;
import common.reeszrbteam.ce.util.CEUtils;


public class WindowInfo extends YAWWindow{
    
	public WindowInfo() 
	{
		super("Info", 278, 85 + 18);
	}
	
	@Override
	public void draw(int x, int y)
	{
		if(isOpen())
		{
			if(dragging)
			{
				windowDragged(x, y);
			}
			
			CEUtils.drawGradientBorderedRect(getX() + dragX, getY() + dragY, getX() + 90 + dragX, getY() + 12 + dragY, 0.5F, 0xFF000000, 0xFF999999, 0xFF777777);
			Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(getTitle(), getX() + 2 + dragX, getY() + dragY + 2, 0x55FFFF);
			
			CEUtils.drawGradientBorderedRect(getX() + 70 + dragX, getY() + 2 + dragY, getX() + 78 + dragX, getY() + 10 + dragY, 1F, 0xFF666666, isPinned() ? 0xFF777777 : 0xFF888888, isPinned() ? 0xFF555555 : 0xFF666666);
			CEUtils.drawGradientBorderedRect(getX() + 80 + dragX, getY() + 2 + dragY, getX() + 88 + dragX, getY() + 10 + dragY, 1F, 0xFF666666, isExtended() ? 0xFF777777 : 0xFF888888, isExtended() ? 0xFF555555 : 0xFF666666);
			
			if(isExtended())
			{
				CEUtils.drawGradientBorderedRect(getX() + dragX, getY() + 14 + dragY, getX() + 90 + dragX, getY() + 84 + dragY, 0.5F, 0xFF000000, 0xFF999999, 0xFF777777);
				
				Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Counter: "+Minecraft.getMinecraft().debug.split(",")[0].toUpperCase(), getX() + 2 + dragX, getY() + 15 + dragY, 0x55FFFF);
				Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("X: " + (int)Minecraft.getMinecraft().thePlayer.posX, getX() + 2 + dragX, getY() + 55 + dragY, 0x55FFFF);
				Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Y: " + (int)Minecraft.getMinecraft().thePlayer.posY, getX() + 2 + dragX, getY() + 65 + dragY, 0x55FFFF);
				Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Z: " + (int)Minecraft.getMinecraft().thePlayer.posZ, getX() + 2 + dragX, getY() + 75 + dragY, 0x55FFFF);
				Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("User: "+Minecraft.getMinecraft().thePlayer.username, getX() + 2 + dragX, getY() + 25 + dragY, 0x55FFFF);
				Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Ver.: "+CheatingEssentials.mainInstance().modVersion.replace("-", ""), getX() + 2 + dragX, getY() + 35 + dragY, 0x55FFFF);
				
				for(YAWButton button: buttons)
				{
					button.draw();
				}
			}
		}
	}
}