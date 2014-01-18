package cheatingessentials.mod.commands.apicommands;

import cheatingessentials.api.command.Command;
import cheatingessentials.mod.external.config.agce.files.AGCEGeneric;
import cheatingessentials.mod.modulesystem.classes.Speed;
import cheatingessentials.mod.wrapper.Wrapper;

public class ACommandSpeedValue extends Command {

	public ACommandSpeedValue() {
		super("cesv");
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		Double speedvalue = Double.parseDouble(subcommands[0]);
		Speed.SPEED_VALUE = speedvalue;
		AGCEGeneric.INSTANCE.modify("CESpeedValue.txt", speedvalue);
		Wrapper.INSTANCE.addChatMessage("Set speed to: "+speedvalue);
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
