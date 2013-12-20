package net.cheatingessentials.command;

import net.cheatingessentials.api.Command;
import net.cheatingessentials.client.modules.render.BlockFinder;
import net.cheatingessentials.config.agce.AGCEConfigurationNG;
import net.minecraft.client.Minecraft;

public class ACommandBFRadius extends Command {

	public ACommandBFRadius() {
		super("cebfr");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		BlockFinder.BLOCK_RADIUS = Integer.parseInt(subcommands[0]);
		AGCEConfigurationNG.instance.modify("CEBFRadius.txt", BlockFinder.BLOCK_RADIUS);
		Minecraft.getMinecraft().thePlayer.addChatMessage("Block Finder radius set to: "+subcommands[0]+" blocks.");
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
