package cheatingessentials.mod.commands.apicommands;

import net.minecraft.client.Minecraft;
import cheatingessentials.api.command.Command;
import cheatingessentials.mod.wrapper.Wrapper;

public class CommandHelp extends Command {

	public CommandHelp() {
		super("help");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		for(Command commands : CommandManager.commands){
			Wrapper.INSTANCE.addChatMessage("Command: "+commands.getCommand()+" - "+commands.getDescription());
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Show help";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return null;
	}

}
