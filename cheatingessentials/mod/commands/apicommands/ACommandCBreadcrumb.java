package cheatingessentials.mod.commands.apicommands;

import net.minecraft.client.Minecraft;
import cheatingessentials.api.command.Command;
import cheatingessentials.mod.modulesystem.classes.Breadcrumb;
import cheatingessentials.mod.wrapper.Wrapper;

public class ACommandCBreadcrumb extends Command {

	public ACommandCBreadcrumb() {
		super("cebc");
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		Breadcrumb.positionsList.clear();
		Wrapper.INSTANCE.addChatMessage("Cleared Breadcrumbs");
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
