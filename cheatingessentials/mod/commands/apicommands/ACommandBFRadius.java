package cheatingessentials.mod.commands.apicommands;

import cheatingessentials.api.command.Command;
import cheatingessentials.mod.external.config.forge.GeneralConfiguration;
import cheatingessentials.mod.modulesystem.classes.BlockFinder;
import cheatingessentials.mod.wrapper.Wrapper;

public class ACommandBFRadius extends Command {

	public ACommandBFRadius() {
		super("cebfr");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		BlockFinder.BLOCK_RADIUS = Integer.parseInt(subcommands[0]);
		GeneralConfiguration.instance().configuration.save();
		GeneralConfiguration.instance().configuration.load();
		Wrapper.INSTANCE.addChatMessage("Block Finder radius set to: "+subcommands[0]+" blocks.");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Changes BlockESP / Finder radius";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return this.getCommand().concat(" <radius>");
	}

}
