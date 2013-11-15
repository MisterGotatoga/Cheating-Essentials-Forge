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
		DynamicLogger.instance().writeInfo("Client / Server logged in - Cheating Essentials is handling it... (username: "+Minecraft.getMinecraft().thePlayer.username+")");
	}
	
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) 
	{
		ModuleStateConfiguration.instance().read();
	}
	
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) { return null; }
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {}
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) {}
	public void connectionClosed(INetworkManager manager) {}
}
