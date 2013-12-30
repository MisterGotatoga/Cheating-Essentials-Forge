package net.cheatingessentials.client.command;

import net.cheatingessentials.client.modules.player.Step;
import net.cheatingessentials.config.agce.AGCEConfigurationNG;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandStepHeight extends CommandBase {

	@Override
	public String getCommandName() {
		return "cesh";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/cesh number of blocks to step";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		try{
			float string = Float.parseFloat(astring[0]);
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
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
