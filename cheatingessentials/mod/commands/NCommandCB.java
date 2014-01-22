package cheatingessentials.mod.commands;

import cheatingessentials.mod.modulesystem.classes.Breadcrumb;
import cheatingessentials.mod.wrapper.Wrapper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class NCommandCB extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "breadcrumb";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		// TODO Auto-generated method stub
		return "Clear breadcrumb";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2)
	{
		Breadcrumb.positionsList.clear();
		Wrapper.INSTANCE.addChatMessage("Cleared breadcrumb list.");
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean canCommandSenderUseCommand(ICommandSender var1)
	{
		return true;
	}

}
