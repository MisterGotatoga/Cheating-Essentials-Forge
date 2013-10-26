package common.kodehawa.reeszrbteam.ce.gui.click.windows;

import net.minecraft.client.Minecraft;

import common.kodehawa.reeszrbteam.ce.gui.click.YouAlwaysWinClickGui;
import common.kodehawa.reeszrbteam.ce.gui.click.elements.YAWWindow;
import common.kodehawa.reeszrbteam.ce.util.CEUtils;

public class WindowHub extends YAWWindow
{
	public WindowHub()
	{
		super("Gui Hub", 2, 14);
	}
	
	@Override
	public void draw(int x, int y)
	{
		super.draw(x, y);

		if(isExtended())
		{
			CEUtils.drawGradientBorderedRect(2 + dragX, getY() + 14 + dragY, getX() + 90 + dragX, (YouAlwaysWinClickGui.unFocusedWindows.size() * 13) + 15 + dragY, 0.5F, 0xFF000000, 0xFF999999, 0xFF777777);

			int size = 0;
			for(YAWWindow window: YouAlwaysWinClickGui.unFocusedWindows)
			{
				if(!window.getTitle().equalsIgnoreCase(this.getTitle()))
				{
					int yPosition = (12 * size) + 18 + dragY;
					CEUtils.drawGradientBorderedRect(4 + dragX, 12 + yPosition, getX() + 88 + dragX, yPosition + 24, 1.0F, 0xFF444444, !window.isOpen() ? 0xFF777777 : 0xFF555555, !window.isOpen() ? 0xFF555555 : 0xFF666666);

					Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(window.getTitle().equalsIgnoreCase("Enabled:") ? "ArrayList" : window.getTitle(), 76 - Minecraft.getMinecraft().fontRenderer.getStringWidth(window.getTitle()) / 2 + this.dragX - 30, yPosition + 15, window.isOpen() ? 0x55FFFF : 0xBBBBBB);    
					size++;
				}
			}
		}
	}
	
	@Override
	public void mouseClicked(int x, int y, int button)
	{
		super.mouseClicked(x, y, button);
		
		int size = 0;
		for(YAWWindow window: YouAlwaysWinClickGui.unFocusedWindows)
		{
			if(!window.getTitle().equalsIgnoreCase(this.getTitle()) && this.isExtended())
			{
				int i = (12 * size) + 18;
				if(x >= 4 + dragX && y >= i + 12 + dragY && x <= getX() + 88 + dragX && y <= i + 24 + dragY)
				{
					Minecraft.getMinecraft().sndManager.playSoundFX("random.click", 1.0F, 1.0F);
					window.setOpen(!window.isOpen());
				}
				size++;
			}
		}
	}
}

