package net.cheatingessentials.client.command;

import net.cheatingessentials.client.modules.classes.Breadcrumb;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

public class CommandBreadcrumbClear extends CommandBase {

	@Override
	public String getCommandName() {
		return "cecb";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/cecb";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		Breadcrumb.positionsList.clear();
		icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Deleted breadcrumbs"));
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}
}
