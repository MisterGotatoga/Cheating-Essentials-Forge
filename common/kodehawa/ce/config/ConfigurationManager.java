package common.kodehawa.ce.config;

import common.kodehawa.ce.module.classes.BlockFinder;
import common.kodehawa.ce.module.classes.XRay;
import common.kodehawa.ce.relations.PlayerRelations;

/**
 * Class that loads / writes all the configurations in Cheating Essentials.
 * @author Kodehawa
 */

public class ConfigurationManager {

	private volatile static ConfigurationManager instance = new ConfigurationManager();
	public static boolean universalDebug;
	
	public ConfigurationManager() 
	{
		PlayerRelations.instance();
		new AGCEConfigurationBoolean("Debug Config", this.getClass(), "universalDebug", universalDebug, "CEDebugConfig.txt");
		new AGCEConfigurationSList("Friend List", "CEFriends.txt", PlayerRelations.instance().friends);
		new AGCEConfigurationSList("Enemy List", "CEEnemies.txt", PlayerRelations.instance().enemies);
		new AGCEConfigurationIList("BlockESP List", "CEBlockESPList.txt", BlockFinder.espList);
		new AGCEConfigurationIList("X-Ray List", "CEXrayBlocks.txt", XRay.xrayList2);
		KeybindConfiguration.instance();
	}
	
	public static ConfigurationManager instance()
	{
		return instance;
	}
}