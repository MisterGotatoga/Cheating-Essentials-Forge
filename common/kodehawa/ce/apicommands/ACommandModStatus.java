package common.kodehawa.ce.apicommands;

import net.minecraft.client.Minecraft;
import common.kodehawa.api.console.BaseCommand;
import common.kodehawa.ce.config.ConfigurationManager;
import common.kodehawa.ce.main.CheatingEssentials;
import common.kodehawa.ce.module.man.ModuleManager;

public class ACommandModStatus extends BaseCommand {

	private Minecraft mc = Minecraft.getMinecraft();
	
	public ACommandModStatus() {
		super("cestatus");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		mc.thePlayer.addChatMessage("Cheating Essentials mod for Minecraft, information: ");
		mc.thePlayer.addChatMessage("--------------------------");
		mc.thePlayer.addChatMessage("Version: "+CheatingEssentials.mainInstance().modVersion);
		mc.thePlayer.addChatMessage("A.G.C.E version: "+ConfigurationManager.instance().getConfigurationSystemVersion());
		mc.thePlayer.addChatMessage("Module Manager version: "+ModuleManager.instance().getModuleManagerVersion());
		mc.thePlayer.addChatMessage("Development date: November 14th, 2013");
		mc.thePlayer.addChatMessage("Credits: Kodehawa, ReesZRB");
		mc.thePlayer.addChatMessage("Modules Loaded: "+ModuleManager.instance().avModules.size());

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Show CE Status";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return null;
	}

}
