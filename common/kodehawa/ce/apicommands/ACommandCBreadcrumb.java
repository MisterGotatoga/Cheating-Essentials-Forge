package common.kodehawa.ce.apicommands;

import net.minecraft.client.Minecraft;
import common.kodehawa.api.console.BaseCommand;
import common.kodehawa.ce.module.classes.Breadcrumb;

public class ACommandCBreadcrumb extends BaseCommand {

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
