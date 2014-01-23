package cheatingessentials.mod.screens;

import net.minecraft.client.gui.GuiScreen;

import org.lwjgl.opengl.GL11;

import cheatingessentials.mod.wrapper.Wrapper;

public class LoadingScreen extends GuiScreen
{
	
	public static boolean main;
	public static boolean module;
	public static boolean gui;
	public static boolean config;
	public static boolean last;
	public static boolean commands;
	
    public void drawScreen(int par1, int par2, float par3)
    {
    	GL11.glPushMatrix();
    	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    	GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glClearColor(5.0F, 5.0F, 5.0F, 1.0F);
        GL11.glTranslated(0, 5, 0);
        GL11.glScalef(3.5F, 3.5F, 3.5F);
        Wrapper.INSTANCE.minecraft().fontRenderer.drawString("Wait while we init Cheating Essentials for you...", 0, 0, 0xfffffff);
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        
        if(main)
        {
        	 Wrapper.INSTANCE.minecraft().fontRenderer.drawString("Loading main mod...", 0, 2, 0xfffffff);
        }
        
        if(module)
        {
        	 Wrapper.INSTANCE.minecraft().fontRenderer.drawString("Loading modules...", 0, 2, 0xfffffff);
        }
        
        if(gui)
        {
        	 Wrapper.INSTANCE.minecraft().fontRenderer.drawString("Loading Gui...", 0, 2, 0xfffffff);
        }
        
        if(config)
        {
        	 Wrapper.INSTANCE.minecraft().fontRenderer.drawString("Preparing config...", 0, 2, 0xfffffff);
        }
        
        if(last)
        {
        	 Wrapper.INSTANCE.minecraft().fontRenderer.drawString("Completed.", 0, 2, 0xfffffff);
        }
        
        GL11.glPopMatrix();
    }
}
