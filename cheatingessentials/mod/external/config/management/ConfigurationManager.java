package cheatingessentials.mod.external.config.management;

public class ConfigurationManager 
{
	
	private static volatile ConfigurationManager INSTANCE = new ConfigurationManager();
	
	public ConfigurationManager()
	{
		
	}
	
	public static ConfigurationManager instance()
	{
		return INSTANCE;
	}

}
