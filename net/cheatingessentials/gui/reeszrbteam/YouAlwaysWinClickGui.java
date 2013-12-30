package net.cheatingessentials.gui.reeszrbteam;

import java.util.ArrayList;

import net.cheatingessentials.api.Command;
import net.cheatingessentials.command.CommandManager;
import net.cheatingessentials.config.ModuleStateConfiguration;
import net.cheatingessentials.config.SaveableGuiState;
import net.cheatingessentials.gui.reeszrbteam.element.YAWWindow;
import net.cheatingessentials.gui.reeszrbteam.window.WindowActives;
import net.cheatingessentials.gui.reeszrbteam.window.WindowHub;
import net.cheatingessentials.gui.reeszrbteam.window.WindowInfo;
import net.cheatingessentials.gui.reeszrbteam.window.WindowPlayer;
import net.cheatingessentials.gui.reeszrbteam.window.WindowRadar;
import net.cheatingessentials.gui.reeszrbteam.window.WindowRender;
import net.cheatingessentials.gui.reeszrbteam.window.WindowUtils;
import net.cheatingessentials.gui.reeszrbteam.window.WindowWorld;
import net.cheatingessentials.util.RZUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatAllowedCharacters;

import org.lwjgl.input.Keyboard;

public class YouAlwaysWinClickGui extends GuiScreen
{
	public static ArrayList<YAWWindow> windows = new ArrayList<YAWWindow>();
	public static ArrayList<YAWWindow> unFocusedWindows = new ArrayList<YAWWindow>();
	public static boolean isDark = false;
	ArrayList cmds = new ArrayList();
	public static ArrayList OrgName = new ArrayList();
	public static ArrayList NameP = new ArrayList();
	protected String message = "";
	private int updateCounter = 0;
	private static final char[] allowedCharacters = ChatAllowedCharacters.allowedCharactersArray;
	
	public YAWWindow guiHub = new WindowHub();
	public YAWWindow player = new WindowPlayer().init();
	public YAWWindow world = new WindowWorld().init();
	public YAWWindow info = new WindowInfo();
	public YAWWindow radar = new WindowRadar();
    public YAWWindow render = new WindowRender().init();
    public YAWWindow utils = new WindowUtils().init();
    public YAWWindow actives = new WindowActives();
	
    public YouAlwaysWinClickGui()
    {
    	this.cmds.clear();
	    for(Command c : CommandManager.commands)
	    {
	    	this.cmds.add(c.getCommand() + " - " + c.getDescription());
	    }
    }
    
	public void initGui()
	{
		super.initGui();
		SaveableGuiState.instance().read();
        Keyboard.enableRepeatEvents(true);
		guiHub.setOpen(true);
	}
	
	public void func_146274_d()
	{
		super.func_146274_d();
    	this.message = "";
        Keyboard.enableRepeatEvents(false);
		ModuleStateConfiguration.instance().writeToFile();
		SaveableGuiState.instance().writeToFile();
	}
	
	public static void sendPanelToFront(YAWWindow window)
	{
		if(windows.contains(window))
		{
			int panelIndex = windows.indexOf(window);
			windows.remove(panelIndex);
			windows.add(windows.size(), window);
		}
	}
	
	public static YAWWindow getFocusedPanel()
	{
		return windows.get(windows.size() - 1);
	}
	
	/**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char var1, int var2)
    {
        String var3;
 
        if (var1 == 22)
        {
            //var3 = GuiScreen.getClipboardString();
 
            /*if (var3 != null)
            {
            	//this.message = this.message + var3;
            }*/
        }
 
        if (var2 == 1)
        {
            Minecraft.getMinecraft().func_147108_a(null);;
        }
        else if (var2 == 28)
        {
            var3 = this.message.trim();
            String[] var4;
            String var5;
            
            try
            {
                CommandManager.instance().runCommands("." + var3);
            }
            catch(Exception e)
            {
            	for(Command command : CommandManager.commands)
            	{
            		if(message.contains(command.getCommand()))
            		{
                		command.getSyntax();
            		}
            	}
            }
            message = "";
        }
        else
        {
            if (var2 == 14 && this.message.length() > 0)
            {
                this.message = this.message.substring(0, this.message.length() - 1);
            }
 
            if (allowedCharacters.length >= 0 && this.message.length() < 100)
            {
                this.message = this.message + var1;
            }
        }
    }

	
	public void drawScreen(int x, int y, float f)
	{
		super.drawScreen(x, y, f);
        int var4 = 24;
        
        for (int var5 = 0; var5 < this.cmds.size(); ++var5)
        {
            String var6 = (String)this.cmds.get(var5);
 
            if (var6.startsWith(this.message) && this.message.length() > 0)
            {
                RZUtils.drawBorderedRect(83 + 4, var4 - 6,83 + this.field_146289_q.getStringWidth(var6) + 8, var4 + 6, 1, -15066598, -14145496);
                
                this.drawString(this.field_146289_q, var6,83 + 6, var4 - 4, 16777215);
                var4 += 14;
            }
        }
 
        RZUtils.drawBorderedRect(83 + 4, 0, this.field_146294_l - 60, 12, 1, -15066598, -14145496);
        Minecraft.getMinecraft().fontRenderer.drawString("CE Console ",  83 + 10, 2, 0x55FFFF);
        
        this.drawString(this.field_146289_q, "" + (this.updateCounter / 12 % 2 != 0 ? "\u00a7b>\u00a77 " : "\u00a73>\u00a77 ") + this.message + (this.updateCounter / 12 % 2 != 0 ? " \u00a7b_" : " \u00a73_"), this.field_146289_q.getStringWidth("CE Console ") + 83 + 10, 2, 14737632);
		for(YAWWindow window: windows)
		{
			window.draw(x, y);
		}
		//CEUtils.drawRect(0, 150, this.width, 160, 0x000000);
	}
		
    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        ++this.updateCounter;
        super.updateScreen();
    }
    
	public void mouseClicked(int x, int y, int button)
	{
		try
		{
			for(YAWWindow window: windows)
			{
				window.mouseClicked(x, y, button);
			}
		}
		catch(Exception e) {}
	}
	
	public void mouseMovedOrUp(int x, int y, int button)
	{
		for(YAWWindow window: windows)
		{
			window.mouseMovedOrUp(x, y, button);
		}
	}
	
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
