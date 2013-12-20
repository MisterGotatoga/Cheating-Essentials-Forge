package net.cheatingessentials.client.modules.world;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class Day extends Module {

	public Day() {
		super(Category.WORLD);
	}

	@Override
	public String getModuleName(){
		return "Set Day";
	}
	
	@Override
	public String showHelp(){
		return "Sets the Minecraft time to day.s";
	}
	
	public void enable(){
		for(WorldServer worldserver : MinecraftServer.getServer().worldServers){
			worldserver.setWorldTime(200);
		}
	}
}
