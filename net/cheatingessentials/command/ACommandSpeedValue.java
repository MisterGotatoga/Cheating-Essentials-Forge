package net.cheatingessentials.command;

import net.cheatingessentials.api.Command;
import net.cheatingessentials.client.modules.classes.Speed;
import net.cheatingessentials.config.agce.AGCEConfigurationNG;
import net.minecraft.client.Minecraft;

public class ACommandSpeedValue extends Command {

	public ACommandSpeedValue() {
		super("cesv");
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		Double speedvalue = Double.parseDouble(subcommands[0]);
		Speed.SPEED_VALUE = speedvalue;
		AGCEConfigurationNG.instance.modify("CESpeedValue.txt", speedvalue);
		Minecraft.getMinecraft().thePlayer.addChatMessage("Set speed to: "+speedvalue);
	}

	@Override
	public String getDescription() {
		return "Sets player speed (Speed Module)";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return this.getCommand()+" number of blocks/second";
	}

}
