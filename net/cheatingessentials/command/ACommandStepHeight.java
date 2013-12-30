package net.cheatingessentials.command;

import net.cheatingessentials.api.Command;
import net.cheatingessentials.client.modules.player.Step;
import net.cheatingessentials.config.agce.AGCEConfigurationNG;
import net.minecraft.client.Minecraft;

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
				Minecraft.getMinecraft().thePlayer.sendChatMessage("Set step height to: "+string);
				AGCEConfigurationNG.instance.modify("CEStepValue.txt", Step.DEFAULT_STEP_HEIGHT);
			}
			else{
				Minecraft.getMinecraft().thePlayer.sendChatMessage("Can't set step height more than 100 blocks!");
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
