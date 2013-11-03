package common.kodehawa.ce.commands;

import common.kodehawa.ce.module.classes.Step;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

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
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Set step height to: "+string));
			}
			else{
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Can't set step height more than 100 blocks!"));
			}
		}
		catch(Exception e){}
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}
}
