package common.kodehawa.api.console;

import java.util.ArrayList;
import java.util.logging.Level;

import common.kodehawa.ce.logger.DynamicLogger;
import common.kodehawa.ce.main.CheatingEssentials;
import net.minecraft.client.Minecraft;

public class CommandManager
{
	public static ArrayList<BaseCommand> commands = new ArrayList<BaseCommand>();
    private volatile static CommandManager instance;
	
	public static char cmdPrefix = '.';

	public CommandManager()
	{
		DynamicLogger.instance().writeLogWithPrefix("RZCA", "ReesZRB Console API ["+this+"] starting on Cheating Essentials "+CheatingEssentials.mainInstance().modVersion, Level.INFO, 1);
		addCommand(new CommandHelp());
	}
	
	public void runCommands(String s)
	{
		boolean commandResolved = false;
		String readString = s.trim().substring(Character.toString(cmdPrefix).length()).trim();
		boolean hasArgs = readString.trim().contains(" ");
		String commandName = hasArgs ? readString.split(" ")[0] : readString.trim();
		String[] args = hasArgs ? readString.substring(commandName.length()).trim().split(" ") : new String[0];

		for(BaseCommand command: commands)
		{	
			if(command.getCommand().trim().equalsIgnoreCase(commandName.trim())) 
			{
				command.runCommand(readString, args);
				commandResolved = true;
				break;
			}
		}

		if(!commandResolved)
		{
			Minecraft.getMinecraft().thePlayer.addChatMessage("[Console API] Invalid command. Type help in Console for a list of commands.");
		}
	}
	
	public void addCommand(BaseCommand command)
	{
		commands.add(command);
	}
	
	public static CommandManager instance(){
		if(instance == null){
			instance = new CommandManager();
		}
		return instance;
	}
}