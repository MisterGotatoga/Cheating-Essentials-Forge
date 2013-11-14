package common.kodehawa.ce.apicommands;

import net.minecraft.client.Minecraft;
import common.kodehawa.api.console.BaseCommand;
import common.kodehawa.ce.config.AGCEConfigurationNG;
import common.kodehawa.ce.module.classes.ChestFinder;

public class ACommandCFRadius extends BaseCommand {

	public ACommandCFRadius() {
		super("cecfr");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		ChestFinder.BLOCK_RADIUS = Integer.parseInt(subcommands[0]);
		AGCEConfigurationNG.instance.modify("CECFRadius.txt", ChestFinder.BLOCK_RADIUS);
		Minecraft.getMinecraft().thePlayer.addChatMessage("Modified Chest Finder Radius: "+subcommands[0]);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Changes ChestESP/Finder radius";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return this.getCommand().concat(" <radius> (Limit on X-Z to show the ESP box)");
	}

}
