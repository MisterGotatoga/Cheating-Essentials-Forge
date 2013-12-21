package net.cheatingessentials.gui.reeszrbteam.window;

import net.cheatingessentials.client.modules.general.ModuleManager;
import net.cheatingessentials.gui.reeszrbteam.element.YAWButton;
import net.cheatingessentials.gui.reeszrbteam.element.YAWWindow;
import net.cheatingessentials.util.RZUtils;
import net.minecraft.client.Minecraft;

public class WindowActives extends YAWWindow {

	public WindowActives() {
		super("Enabled", 212, 36);
	}
	
	public void draw(int x, int y){
		if(isOpen())
		{
			if(dragging)
			{
				windowDragged(x, y);
			}
			RZUtils.drawGradientBorderedRect(getX() + dragX, getY() + dragY, getX() + 90 + dragX, getY() + 12 + dragY, 0.5F, 0xFF000000, 0xFF999999, 0xFF777777);
			Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(getTitle(), getX() + 2 + dragX, getY() + dragY + 2, 0x55FFFF);
			
			RZUtils.drawGradientBorderedRect(getX() + 70 + dragX, getY() + 2 + dragY, getX() + 78 + dragX, getY() + 10 + dragY, 1F, 0xFF666666, isPinned() ? 0xFF777777 : 0xFF888888, isPinned() ? 0xFF555555 : 0xFF666666);
			RZUtils.drawGradientBorderedRect(getX() + 80 + dragX, getY() + 2 + dragY, getX() + 88 + dragX, getY() + 10 + dragY, 1F, 0xFF666666, isExtended() ? 0xFF777777 : 0xFF888888, isExtended() ? 0xFF555555 : 0xFF666666);
			
			if(isExtended())
			{				
				for(int i = 0; i < ModuleManager.instance().enabled.size(); i++){
					RZUtils.drawGradientBorderedRect(getX() + dragX, getY() + 14 + dragY, getX() + 90 + dragX, getY() + 14 + dragY + ModuleManager.instance().enabled.size() + ((12*(i+1)) - (i*4)), 0.5F, 0xFF000000, 0xFF999999, 0xFF777777);
				}
					for(int i = 0; i < ModuleManager.instance().enabled.size(); i++){
					Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(" " + ModuleManager.instance().enabled.get(i), getX() + dragX,
							(i <= 5 ? getY() : getY() - 8) + dragY + 1 + ModuleManager.instance().enabled.size() + ((12*(i+1)) - (i*3)), 0x55FFFF);
				}
				
				for(YAWButton button: buttons)
				{
					button.draw();
				}
			}
		}
	}
}

