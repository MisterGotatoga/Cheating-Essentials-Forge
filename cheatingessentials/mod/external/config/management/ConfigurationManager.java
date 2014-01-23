package cheatingessentials.mod.external.config.management;

import cheatingessentials.mod.external.config.agce.files.AGCEIntegerList;
import cheatingessentials.mod.external.config.agce.files.AGCEStringList;
import cheatingessentials.mod.external.config.manual.KeybindConfiguration;
import cheatingessentials.mod.external.config.manual.ModuleStateConfiguration;
import cheatingessentials.mod.external.config.manual.SaveableGuiState;
import cheatingessentials.mod.main.CheatingEssentials;
import cheatingessentials.mod.modulesystem.classes.BlockFinder;
import cheatingessentials.mod.relationsystem.Enemy;
import cheatingessentials.mod.relationsystem.Friend;

/**
 * Configuration Management for AGCE System (I don't remember why I called it AGCE but anyway). This should
 * call any configuration that needs to be written/readed in the constructor. The current categories of AGCE
 * Configs are {@link AGCEGeneric}, {@link AGCEIntegerList} and {@link AGCEStringList}. This can handle manual and more
 * complex configurations like the Module State or the Keybinding one.
 * @author Kodehawa
 */
public class ConfigurationManager 
{
	private static volatile ConfigurationManager INSTANCE = new ConfigurationManager();
	
	public ConfigurationManager()
	{
		CheatingEssentials.INSTANCE.logger.info("Automated Cheating Essentials Configuration System initializing...");
		
		new AGCEIntegerList("Block Finder list", "CE-BlockFinderList.cfg", BlockFinder.idEspList);
		new AGCEIntegerList("Block Finder metadata list", "CE-BlockFinderMetaList.cfg", BlockFinder.metaEspList);
		
		new AGCEStringList("Friend List", "CE-FriendList.cfg", Friend.instance().friendList);
		new AGCEStringList("Enemy List", "CE-EnemyList.cfg", Enemy.instance().enemyList);
		
		new KeybindConfiguration();
		new ModuleStateConfiguration();
		new SaveableGuiState();
		
		CheatingEssentials.INSTANCE.logger.info("Automated Cheating Essentials Configuration System initialized.");
	}
	
	public static ConfigurationManager instance()
	{
		return INSTANCE;
	}

}
