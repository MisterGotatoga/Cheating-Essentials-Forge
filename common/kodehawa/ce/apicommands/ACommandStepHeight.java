package common.kodehawa.ce.apicommands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatMessageComponent;
import common.kodehawa.api.console.BaseCommand;
import common.kodehawa.ce.config.AGCEConfigurationNG;
import common.kodehawa.ce.module.classes.Step;

public class ACommandStepHeight extends BaseCommand {

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
				Minecraft.getMinecraft().thePlayer.addChatMessage("Set step height to: "+string);
				AGCEConfigurationNG.instance.modify("CEStepValue.txt", Step.DEFAULT_STEP_HEIGHT);
			}
			else{
				Minecraft.getMinecraft().thePlayer.addChatMessage("Can't set step height more than 100 blocks!");
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
