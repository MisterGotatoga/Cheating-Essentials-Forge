package cheatingessentials.mod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import cheatingessentials.mod.external.config.forge.GeneralConfiguration;
import cheatingessentials.mod.modulesystem.classes.Step;
import cheatingessentials.mod.wrapper.Wrapper;

public class NCommandSH extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "cesh";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		// TODO Auto-generated method stub
		return "Changes step height";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		// TODO Auto-generated method stub
		try{
			float string = Float.parseFloat(var2[0]);
			if(string < 100F){
				Step.DEFAULT_STEP_HEIGHT = string;
				Wrapper.INSTANCE.addChatMessage("Set step height to: "+string);
				GeneralConfiguration.instance().configuration.save();
				GeneralConfiguration.instance().configuration.load();
			}
			else{
				Wrapper.INSTANCE.addChatMessage("Can't set step height more than 100 blocks!");
			}
		}
		catch(Exception e){}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
