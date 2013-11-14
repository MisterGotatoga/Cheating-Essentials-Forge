package common.kodehawa.ce.apicommands;

import net.minecraft.client.Minecraft;

import common.kodehawa.api.console.BaseCommand;
import common.kodehawa.ce.config.AGCEConfigurationNG;
import common.kodehawa.ce.module.classes.Speed;

public class ACommandSpeedValue extends BaseCommand {

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
