package net.cheatingessentials.client.command;

import net.cheatingessentials.client.modules.render.Breadcrumb;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

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
		Minecraft.getMinecraft().thePlayer.sendChatMessage("Deleted breadcrumbs");
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
