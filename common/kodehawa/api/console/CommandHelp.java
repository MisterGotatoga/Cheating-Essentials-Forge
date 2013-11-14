package common.kodehawa.api.console;

import net.minecraft.client.Minecraft;

public class CommandHelp extends BaseCommand {

	public CommandHelp() {
		super("help");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		for(BaseCommand commands : CommandManager.commands){
			Minecraft.getMinecraft().thePlayer.addChatMessage("Command: "+commands.getCommand()+" - "+commands.getDescription());
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
