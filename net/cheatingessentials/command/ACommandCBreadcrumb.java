package net.cheatingessentials.command;

import net.cheatingessentials.api.Command;
import net.cheatingessentials.client.modules.classes.Breadcrumb;
import net.minecraft.client.Minecraft;

public class ACommandCBreadcrumb extends Command {

	public ACommandCBreadcrumb() {
		super("cebc");
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		Breadcrumb.positionsList.clear();
		Minecraft.getMinecraft().thePlayer.addChatMessage("Cleared Breadcrumbs");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Clear breadcrumbs from world";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
