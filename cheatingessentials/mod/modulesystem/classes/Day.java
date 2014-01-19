package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;

public class Day extends Mod {

	public Day()
	{
		super(ModuleCategories.WORLD);
	}

	@Override
	public String getName(){
		return "Set Day";
	}
	
	@Override
	public String getDescription(){
		return "Sets the Minecraft time to day.s";
	}
	
	public void enable(){
		for(WorldServer worldserver : MinecraftServer.getServer().worldServers){
			worldserver.setWorldTime(200);
		}
	}
}
