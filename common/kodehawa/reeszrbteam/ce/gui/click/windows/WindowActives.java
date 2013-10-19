package common.kodehawa.reeszrbteam.ce.gui.click.windows;

import net.minecraft.client.Minecraft;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.man.ModuleManager;
import common.kodehawa.reeszrbteam.ce.gui.click.elements.YAWButton;
import common.kodehawa.reeszrbteam.ce.gui.click.elements.YAWWindow;
import common.kodehawa.reeszrbteam.ce.util.CEUtils;

public class WindowActives extends YAWWindow {

	public WindowActives() {
		super("Enabled:", 186, 33);
	}
	
	public void draw(int x, int y){
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
				for(int i = 0; i < ModuleManager.instance().enabled.size(); i++){
					CEUtils.drawGradientBorderedRect(getX() + dragX, getY() + 14 + dragY, getX() + 90 + dragX, getY() + 14 + dragY + ModuleManager.instance().enabled.size() + ((12*(i+1)) - (i*3)), 0.5F, 0xFF000000, 0xFF999999, 0xFF777777);
				}
					for(int i = 0; i < ModuleManager.instance().enabled.size(); i++){
					Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(" " + ModuleManager.instance().enabled.get(i), getX() + dragX,
							getY() + dragY + 1 + ModuleManager.instance().enabled.size() + ((12*(i+1)) - (i*3)), 0x55FFFF );
				}
				
				for(YAWButton button: buttons)
				{
					button.draw();
				}
			}
		}
	}
	
	public static void drawCenteredString(String string, int x, int y, int color)
    {
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(string, x - Minecraft.getMinecraft().fontRenderer.getStringWidth(string) / 4, y, color);
    }
}

