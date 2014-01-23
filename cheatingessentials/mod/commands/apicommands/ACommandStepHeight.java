package cheatingessentials.mod.commands.apicommands;

import cheatingessentials.api.command.Command;
import cheatingessentials.mod.external.config.forge.GeneralConfiguration;
import cheatingessentials.mod.modulesystem.classes.Step;
import cheatingessentials.mod.wrapper.Wrapper;

public class ACommandStepHeight extends Command {

	public ACommandStepHeight() {
		super("cesh");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		try{
			float string = Float.parseFloat(subcommands[0]);
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
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Sets step height";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return this.getCommand()+" <number of blocks (float)>";
	}

}
