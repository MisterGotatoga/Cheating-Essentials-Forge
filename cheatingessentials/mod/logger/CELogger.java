package cheatingessentials.mod.logger;

import java.util.logging.Logger;

public class CELogger 
{
	private Logger log;
	
	public CELogger(String s)
	{
		log = Logger.getLogger(s);
	}
	
	public void info(String s)
	{
		log.info(s);
	}

	public void warning(String s)
	{
		log.warning(s);
	}
	
	public void severe(String s)
	{
		log.severe(s);
	}
}
