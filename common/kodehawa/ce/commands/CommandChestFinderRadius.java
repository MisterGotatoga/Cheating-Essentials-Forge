package common.kodehawa.ce.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

import common.kodehawa.ce.config.AGCEConfigurationNG;
import common.kodehawa.ce.module.classes.ChestFinder;

public class CommandChestFinderRadius extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "cecfr";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "/cecfr <number of block radius (Limit in X-Z to show blocks)>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		ChestFinder.BLOCK_RADIUS = Integer.parseInt(astring[0]);
		AGCEConfigurationNG.instance.modify("CECFRadius.txt", ChestFinder.BLOCK_RADIUS);
		icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Setted Chest Finder radius to: "+astring[0]+" blocks."));
	}

}
