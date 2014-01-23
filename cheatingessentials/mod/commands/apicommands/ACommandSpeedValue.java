package cheatingessentials.mod.commands.apicommands;

import net.minecraft.command.ICommandSender;
import cheatingessentials.api.command.Command;
import cheatingessentials.mod.external.config.forge.GeneralConfiguration;
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
		GeneralConfiguration.instance().configuration.save();
		GeneralConfiguration.instance().configuration.load();
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
	
	public boolean canCommandSenderUseCommand(ICommandSender var1)
	{
		return true;
	}

}
