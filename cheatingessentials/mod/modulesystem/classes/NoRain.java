package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.storage.WorldInfo;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;

public class NoRain extends Mod {

	public NoRain()
	{
		super(ModuleCategories.WORLD);
	}
	
	public String getName(){
		return "No Rain";
	}
	
	@Override
	public String getDescription(){
		return "Stops rain.";
	}
	
	@Override
	public void onTick()
	{
		WorldInfo worldInfo = MinecraftServer.getServer().worldServers[0].getWorldInfo();
        worldInfo.setRaining(false);
	}

}
