package cheatingessentials.mod.gui.reeszrbteam;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatAllowedCharacters;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import cheatingessentials.api.command.Command;
import cheatingessentials.mod.commands.apicommands.CommandManager;
import cheatingessentials.mod.external.config.manual.ModuleStateConfiguration;
import cheatingessentials.mod.external.config.manual.SaveableGuiState;
import cheatingessentials.mod.gui.reeszrbteam.element.YAWWindow;
import cheatingessentials.mod.gui.reeszrbteam.window.WindowActives;
import cheatingessentials.mod.gui.reeszrbteam.window.WindowHub;
import cheatingessentials.mod.gui.reeszrbteam.window.WindowInfo;
import cheatingessentials.mod.gui.reeszrbteam.window.WindowMovement;
import cheatingessentials.mod.gui.reeszrbteam.window.WindowPlayer;
import cheatingessentials.mod.gui.reeszrbteam.window.WindowRadar;
import cheatingessentials.mod.gui.reeszrbteam.window.WindowRender;
import cheatingessentials.mod.gui.reeszrbteam.window.WindowUtils;
import cheatingessentials.mod.gui.reeszrbteam.window.WindowWorld;
import cheatingessentials.mod.util.GLUtils;
import cheatingessentials.mod.wrapper.Wrapper;

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
    public YAWWindow movement = new WindowMovement().init();
	
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
	
	public void onGuiClosed()
	{
		//super.onGuiClosed();
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
            var3 = GuiScreen.func_146277_j();
 
            if (var3 != null)
            {
            	this.message = this.message + var3;
            }
        }
 
        if(var1 == 43)
        {
            this.message = this.message.substring(0, this.message.length() - 1);
        }
        
        if (var2 == 1)
        {
            Wrapper.INSTANCE.minecraft().func_147108_a(null);
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
 
            if (this.message.length() < 100 && var1 != 43)
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
                GLUtils.drawBorderedRect(83 + 4, var4 - 6,83 + Minecraft.getMinecraft().fontRenderer.getStringWidth(var6) + 8, var4 + 6, 1, -15066598, -14145496);
                
                this.drawString(Minecraft.getMinecraft().fontRenderer, var6,83 + 6, var4 - 4, 16777215);
                var4 += 14;
            }
        }
 
        GLUtils.drawBorderedRect(83 + 4, 0, this.field_146294_l - 60, 12, 1, -15066598, -14145496);
        Minecraft.getMinecraft().fontRenderer.drawString("CE Console ",  83 + 10, 2, 0x55FFFF);
        
        this.drawString(Minecraft.getMinecraft().fontRenderer, "" + (this.updateCounter / 12 % 2 != 0 ? "\u00a7b>\u00a77 " : "\u00a73>\u00a77 ") + this.message + (this.updateCounter / 12 % 2 != 0 ? " \u00a7b_" : " \u00a73_"), Minecraft.getMinecraft().fontRenderer.getStringWidth("CE Console ") + 83 + 10, 2, 14737632);
		for(YAWWindow window: windows)
		{
			window.draw(x, y);
		}
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
	
    protected void func_146286_b(int p_146286_1_, int p_146286_2_, int p_146286_3_)
	{
		for(YAWWindow window: windows)
		{
			window.mouseMovedOrUp(p_146286_1_, p_146286_2_, p_146286_3_);
		}
	}
	
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
