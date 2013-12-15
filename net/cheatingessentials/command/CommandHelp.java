package net.cheatingessentials.command;

import net.cheatingessentials.api.Command;
import net.minecraft.client.Minecraft;

public class CommandHelp extends Command {

	public CommandHelp() {
		super("help");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		for(Command commands : CommandManager.commands){
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
