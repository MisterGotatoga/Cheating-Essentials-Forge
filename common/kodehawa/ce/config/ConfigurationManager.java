package common.kodehawa.ce.config;

import java.util.logging.Level;

import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.module.classes.BlockFinder;
import common.kodehawa.ce.module.classes.Fly;
import common.kodehawa.ce.module.classes.Speed;
import common.kodehawa.ce.module.classes.Step;
import common.kodehawa.ce.module.classes.XRay;
import common.kodehawa.ce.relations.PlayerRelations;

/**
 * Class that loads / writes all the configurations in Cheating Essentials.
 * @author Kodehawa
 */

public class ConfigurationManager 
{
	
	private volatile static ConfigurationManager instance = new ConfigurationManager();
	public String version = "1.0.2";
	public static boolean universalDebug;
	
	public ConfigurationManager() 
	{
		DynamicLogger.instance().writeLog("Starting A.G.C.E Configuration System on Cheating Essentials...", Level.INFO);
		PlayerRelations.instance();
		ModuleStateConfiguration.instance();
		new AGCEConfigurationBoolean("Debug Config", this.getClass(), "universalDebug", universalDebug, "CEDebugConfig.txt");
		new AGCEConfigurationSList("Friend List", "CEFriends.txt", PlayerRelations.instance().friends);
		new AGCEConfigurationSList("Enemy List", "CEEnemies.txt", PlayerRelations.instance().enemies);
		new AGCEConfigurationNG(BlockFinder.class, "Block Finder Radius", "BLOCK_RADIUS", "CEBFRadius.txt", BlockFinder.BLOCK_RADIUS);
		new AGCEConfigurationNG(Speed.class, "Speed Value", "SPEED_VALUE", "CESpeedValue.txt", Speed.SPEED_VALUE);
		new AGCEConfigurationNG(Step.class, "Step Value", "DEFAULT_STEP_HEIGHT", "CEStepValue.txt", Step.DEFAULT_STEP_HEIGHT);
		new AGCEConfigurationNG(Fly.class, "Fly Speed", "FLY_SPEED", "CEFlySpeed.txt", Fly.FLY_SPEED);
		new AGCEConfigurationIList("BlockESP List", "CEBlockESPList.txt", BlockFinder.espList);
		new AGCEConfigurationIList("X-Ray List", "CEXrayBlocks.txt", XRay.xrayList2);
		KeybindConfiguration.instance();
	}
	
	public static ConfigurationManager instance()
	{
		return instance;
	}
	
	public String getConfigurationSystemVersion()
	{
		return version;
	}
}