package cheatingessentials.mod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import cheatingessentials.api.module.APIModule;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.Wrapper;

public class NCommandMList extends CommandBase {

	@Override
	public String getCommandName() {
		return "ml";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		// TODO Auto-generated method stub
		return "Shows module list.";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) 
	{
		for(Mod mod : APIModule.INSTANCE.mods)
		{
			Wrapper.INSTANCE.addChatMessage(mod.getName() + " - " + mod.getDescription() + " - " + mod.getAlias());
		}
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
