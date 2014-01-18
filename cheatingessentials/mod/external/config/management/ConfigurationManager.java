package cheatingessentials.mod.external.config.management;

import cheatingessentials.mod.external.config.agce.files.AGCEGeneric;
import cheatingessentials.mod.external.config.agce.files.AGCEIntegerList;
import cheatingessentials.mod.modulesystem.classes.BlockFinder;
import cheatingessentials.mod.modulesystem.classes.Fly;
import cheatingessentials.mod.modulesystem.classes.Speed;
import cheatingessentials.mod.modulesystem.classes.Step;

public class ConfigurationManager 
{
	
	private static volatile ConfigurationManager INSTANCE = new ConfigurationManager();
	
	public ConfigurationManager()
	{
		new AGCEGeneric(Fly.class, "Fly Speed", "FLY_SPEED", "CE-FlySpeed.cfg");
		new AGCEGeneric(Step.class, "Step Height", "DEFAULT_STEP_HEIGHT", "CE-StepHeight.cfg");
		new AGCEGeneric(Speed.class, "Player Speed", "SPEED_VALUE", "CE-SpeedValue.cfg");
		new AGCEGeneric(BlockFinder.class, "Block Finder Radius", "BLOCK_RADIUS", "CE-BERadius.cfg");
		
		new AGCEIntegerList("Block Finder list", "CE-BlockFinderList.cfg", BlockFinder.idEspList);
		new AGCEIntegerList("Block Finder metadata list", "CE-BlockFinderMetaList.cfg", BlockFinder.metaEspList);
	}
	
	public static ConfigurationManager instance()
	{
		return INSTANCE;
	}

}
