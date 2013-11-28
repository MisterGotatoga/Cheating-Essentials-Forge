package common.kodehawa.ce.util;

import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import common.kodehawa.ce.config.ModuleStateConfiguration;
import common.kodehawa.ce.logger.DynamicLogger;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class CEConnectionHandler implements IConnectionHandler {

	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) 
	{
		DynamicLogger.instance().writeInfo("Logged in Minecraft Server - Cheating Essentials is handling it... (Player username: "+Minecraft.getMinecraft().thePlayer.username+")");
	}
	
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) 
	{
		DynamicLogger.instance().writeSimple("Handling Module State Configuration for CE on player login...");
		DynamicLogger.instance().writeRaw("IF THERE IS ANY ERROR IN THIS PHASE PLEASE REPORT IT TO david.alejandro.rubio@gmail.com OR CE MINECRAFT FORUM POST.");
		ModuleStateConfiguration.instance().read();
		DynamicLogger.instance().writeSimple("Handled and loaded MSCE.");
	}
	
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) { return null; }
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {}
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) {}
	public void connectionClosed(INetworkManager manager) {}
}
