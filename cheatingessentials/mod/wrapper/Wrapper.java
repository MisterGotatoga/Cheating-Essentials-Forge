package cheatingessentials.mod.wrapper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class Wrapper 
{
	public volatile static Wrapper INSTANCE = new Wrapper();
	
	public Minecraft minecraft()
	{
		return Minecraft.getMinecraft();
	}

	public EntityClientPlayerMP player()
	{
		return Minecraft.getMinecraft().thePlayer;
	}
	
	public WorldClient world()
	{
		return Minecraft.getMinecraft().theWorld;
	}
	
	public GameSettings mcSettings()
	{
		return Minecraft.getMinecraft().gameSettings;
	}
	
	public FontRenderer fontRenderer()
	{
		return Minecraft.getMinecraft().fontRenderer;
	}
	
	public void addChatMessage(String tosend)
	{
		IChatComponent chatcomponent = new ChatComponentText(tosend);
		player().func_145747_a(chatcomponent);
	}
}
