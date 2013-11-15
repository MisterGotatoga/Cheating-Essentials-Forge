package common.kodehawa.api.console;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.util.ChatAllowedCharacters;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
 
public class GuiConsole extends GuiScreen
{
    ArrayList cmds = new ArrayList();
    public static ArrayList OrgName = new ArrayList();
    public static ArrayList NameP = new ArrayList();
    protected String message = "";
    private int updateCounter = 0;
    public NetClientHandler sendQueue;
    private static final String allowedCharacters = ChatAllowedCharacters.allowedCharacters;
 
    public GuiConsole()
    {
        this.cmds.clear();
        for(BaseCommand c : CommandManager.commands){
        	this.cmds.add(c.getCommand() + " - " + c.getDescription());
        }
    }
    public GuiConsole(Minecraft mc)
    {
    	this.mc = mc;
    }
    
    public void addChatMessage(String s)
    {
    	mc.thePlayer.addChatMessage(s);
    }

	/**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        Keyboard.enableRepeatEvents(true);
    }
 
    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed()
    {
    	this.message = "";
        Keyboard.enableRepeatEvents(false);
    }
 
    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        ++this.updateCounter;
    }
 
    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char var1, int var2)
    {
        String var3;
 
        if (var1 == 22)
        {
            var3 = GuiScreen.getClipboardString();
 
            if (var3 != null)
            {
                this.message = this.message + var3;
            }
        }
 
        if (var2 == 1)
        {
            this.mc.displayGuiScreen((GuiScreen)null);
        }
        else if (var2 == 28)
        {
            var3 = this.message.trim();
            String[] var4;
            String var5;
            
            CommandManager.instance().runCommands("." + var3);
            
            this.mc.displayGuiScreen((GuiScreen)null);
        }
        else
        {
            if (var2 == 14 && this.message.length() > 0)
            {
                this.message = this.message.substring(0, this.message.length() - 1);
            }
 
            if (allowedCharacters.indexOf(var1) >= 0 && this.message.length() < 100)
            {
                this.message = this.message + var1;
            }
        }
    }
 
    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int var1, int var2, float var3)
    {
        int var4 = 24;
 
        for (int var5 = 0; var5 < this.cmds.size(); ++var5)
        {
            String var6 = (String)this.cmds.get(var5);
 
            if (var6.startsWith(this.message) && this.message.length() > 0)
            {
                drawBorderedRect(83 + 4, var4 - 6,83 + this.fontRenderer.getStringWidth(var6) + 8, var4 + 6, 1, -15066598, -14145496);
                
            	this.drawString(this.fontRenderer, var6,83 + 6, var4 - 4, 16777215);
                var4 += 14;
            }
        }
 
        drawBorderedRect( 83 + 4, 0, this.width - 60, 12, 1, -15066598, -14145496);
        this.fontRenderer.drawString("CE Console ",  83 + 10, 2, 0x55FFFF);
        this.drawString(this.fontRenderer, "" + (this.updateCounter / 12 % 2 != 0 ? "\u00a7b>\u00a77 " : "\u00a73>\u00a77 ") + this.message + (this.updateCounter / 12 % 2 != 0 ? " \u00a7b_" : " \u00a73_"), this.fontRenderer.getStringWidth("CE Console ") + 83 + 10, 2, 14737632);
        super.drawScreen(var1, var2, var3);
    }
    
    private void drawRect(float paramXStart, float paramYStart, float paramXEnd, float paramYEnd, int paramColor)
	{
		float alpha = (float)(paramColor >> 24 & 0xFF) / 255F;
		float red = (float)(paramColor >> 16 & 0xFF) / 255F;
		float green = (float)(paramColor >> 8 & 0xFF) / 255F;
		float blue = (float)(paramColor & 0xFF) / 255F;

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);

		GL11.glPushMatrix();
		GL11.glColor4f(red, green, blue, alpha);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2d(paramXEnd, paramYStart);
		GL11.glVertex2d(paramXStart, paramYStart);
		GL11.glVertex2d(paramXStart, paramYEnd);
		GL11.glVertex2d(paramXEnd, paramYEnd);
		GL11.glEnd();
		GL11.glPopMatrix();

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
	}
    
	private void drawBorderedRect(double x, double y, double x2, double y2, float l1, int col1, int col2) {
        drawRect((float)x, (float)y, (float)x2, (float)y2, col2);

        float f = (float)(col1 >> 24 & 0xFF) / 255F;
        float f1 = (float)(col1 >> 16 & 0xFF) / 255F;
        float f2 = (float)(col1 >> 8 & 0xFF) / 255F;
        float f3 = (float)(col1 & 0xFF) / 255F;

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);

        GL11.glPushMatrix();
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glLineWidth(l1);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2d(x, y);
        GL11.glVertex2d(x, y2);
        GL11.glVertex2d(x2, y2);
        GL11.glVertex2d(x2, y);
        GL11.glVertex2d(x, y);
        GL11.glVertex2d(x2, y);
        GL11.glVertex2d(x, y2);
        GL11.glVertex2d(x2, y2);
        GL11.glEnd();
        GL11.glPopMatrix();

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
	}
}