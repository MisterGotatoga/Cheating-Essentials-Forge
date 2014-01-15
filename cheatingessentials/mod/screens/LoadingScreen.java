package cheatingessentials.mod.screens;

import net.minecraft.client.gui.GuiScreen;

import org.lwjgl.opengl.GL11;

import cheatingessentials.mod.main.CheatingEssentials;

public class LoadingScreen extends GuiScreen
{
	
    public void drawScreen(int par1, int par2, float par3)
    {
    	GL11.glPushMatrix();
    	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    	GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glClearColor(5.0F, 5.0F, 5.0F, 1.0F);
        GL11.glTranslated(0, 5, 0);
        GL11.glScalef(3.5F, 3.5F, 3.5F);
        CheatingEssentials.INSTANCE.renderFont.drawString("Wait while we configure Cheating Essentials for you...", par1, par2, 0xfffffff);
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        GL11.glPopMatrix();
    }
}
