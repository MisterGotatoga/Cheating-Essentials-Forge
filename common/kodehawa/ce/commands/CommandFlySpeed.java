package common.kodehawa.ce.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

import common.kodehawa.ce.config.AGCEConfigurationNG;
import common.kodehawa.ce.module.classes.Fly;

public class CommandFlySpeed extends CommandBase {

	@Override
	public String getCommandName() {
		return "flyspeed";
	}
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/flyspeed velocity in numbers (since 0.01 to 0.7)";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		float string = Float.parseFloat(astring[0]);
		Fly.FLY_SPEED = string;
		try{
			if(string < 0.7F){
				Minecraft.getMinecraft().thePlayer.capabilities.setFlySpeed(Fly.FLY_SPEED);
				AGCEConfigurationNG.instance.modify("CEFlySpeed.txt", Fly.FLY_SPEED);
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Set Fly Speed to: "+Fly.FLY_SPEED));
			}
			else{
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Can't set values higher than 0.7"));
			}
		}
		catch(Exception e){}
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}
}
