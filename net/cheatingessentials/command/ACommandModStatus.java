package net.cheatingessentials.command;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Command;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.cheatingessentials.config.ConfigurationManager;
import net.cheatingessentials.main.CheatingEssentials;
import net.minecraft.client.Minecraft;

public class ACommandModStatus extends Command {

	private Minecraft mc = Minecraft.getMinecraft();
	
	public ACommandModStatus() {
		super("cestatus");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		mc.thePlayer.sendChatMessage("Cheating Essentials mod for Minecraft, information: ");
		mc.thePlayer.sendChatMessage("--------------------------");
		mc.thePlayer.sendChatMessage("Version: "+CheatingEssentials.mainInstance().modVersion);
		mc.thePlayer.sendChatMessage("A.G.C.E version: "+ConfigurationManager.instance().getConfigurationSystemVersion());
		mc.thePlayer.sendChatMessage("Module Manager version: "+ModuleManager.instance().getModuleManagerVersion());
		mc.thePlayer.sendChatMessage("Development date: November 14th, 2013");
		mc.thePlayer.sendChatMessage("Credits: Kodehawa, ReesZRB");
		mc.thePlayer.sendChatMessage("Modules Loaded: "+APIModule.instance().modules.size());

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
