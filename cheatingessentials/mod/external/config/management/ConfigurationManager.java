package cheatingessentials.mod.external.config.management;

import cheatingessentials.mod.external.config.agce.files.AGCEGeneric;
import cheatingessentials.mod.external.config.agce.files.AGCEIntegerList;
import cheatingessentials.mod.main.CheatingEssentials;
import cheatingessentials.mod.modulesystem.classes.BlockFinder;
import cheatingessentials.mod.modulesystem.classes.Fly;
import cheatingessentials.mod.modulesystem.classes.Speed;
import cheatingessentials.mod.modulesystem.classes.Step;

public class ConfigurationManager 
{
	
	private static volatile ConfigurationManager INSTANCE = new ConfigurationManager();
	
	public ConfigurationManager()
	{
		CheatingEssentials.INSTANCE.logger.info("Automated Cheating Essentials Configuration System initializing...");
		
		new AGCEGeneric(Fly.class, "Fly Speed", "FLY_SPEED", "CE-FlySpeed.cfg", Fly.FLY_SPEED);
		new AGCEGeneric(Step.class, "Step Height", "DEFAULT_STEP_HEIGHT", "CE-StepHeight.cfg", Step.DEFAULT_STEP_HEIGHT);
		new AGCEGeneric(Speed.class, "Player Speed", "SPEED_VALUE", "CE-SpeedValue.cfg", Speed.SPEED_VALUE);
		new AGCEGeneric(BlockFinder.class, "Block Finder Radius", "BLOCK_RADIUS", "CE-BERadius.cfg", BlockFinder.BLOCK_RADIUS);
		
		new AGCEIntegerList("Block Finder list", "CE-BlockFinderList.cfg", BlockFinder.idEspList);
		new AGCEIntegerList("Block Finder metadata list", "CE-BlockFinderMetaList.cfg", BlockFinder.metaEspList);
		
		CheatingEssentials.INSTANCE.logger.info("Automated Cheating Essentials Configuration System initialized.");
	}
	
	public static ConfigurationManager instance()
	{
		return INSTANCE;
	}

}
