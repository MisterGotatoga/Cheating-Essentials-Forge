package cheatingessentials.mod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import cheatingessentials.mod.external.config.forge.GeneralConfiguration;
import cheatingessentials.mod.modulesystem.classes.Speed;
import cheatingessentials.mod.wrapper.Wrapper;

public class NCommandSV extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "cespeedvalue";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		// TODO Auto-generated method stub
		return "Changes the speed of the speed module.";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		// TODO Auto-generated method stub
		Double speedvalue = Double.parseDouble(var2[0]);
		Speed.SPEED_VALUE = speedvalue;
		GeneralConfiguration.instance().configuration.save();
		GeneralConfiguration.instance().configuration.load();
		Wrapper.INSTANCE.addChatMessage("Set speed to: "+speedvalue);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean canCommandSenderUseCommand(ICommandSender var1)
	{
		return true;
	}
}
