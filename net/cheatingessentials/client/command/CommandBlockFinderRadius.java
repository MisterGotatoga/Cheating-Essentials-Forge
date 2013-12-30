package net.cheatingessentials.client.command;

import net.cheatingessentials.client.modules.render.BlockFinder;
import net.cheatingessentials.config.agce.AGCEConfigurationNG;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandBlockFinderRadius extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "ceber";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "/ceber <number of block radius (Limit to show blocks in X-Z)>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		BlockFinder.BLOCK_RADIUS = Integer.parseInt(astring[0]);
		AGCEConfigurationNG.instance.modify("CEBFRadius.txt", BlockFinder.BLOCK_RADIUS);
		Minecraft.getMinecraft().thePlayer.sendChatMessage("Block Finder radius set to: "+astring[0]+" blocks.");
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
