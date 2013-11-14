package common.kodehawa.ce.apicommands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatMessageComponent;
import common.kodehawa.api.console.BaseCommand;
import common.kodehawa.ce.config.AGCEConfigurationNG;
import common.kodehawa.ce.module.classes.Fly;

public class ACommandFlySpeed extends BaseCommand {

	public ACommandFlySpeed() {
		super("flyspeed");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		float string = Float.parseFloat(subcommands[0]);
		Fly.FLY_SPEED = string;
		try{
			if(string < 0.7F){
				Minecraft.getMinecraft().thePlayer.capabilities.setFlySpeed(Fly.FLY_SPEED);
				AGCEConfigurationNG.instance.modify("CEFlySpeed.txt", Fly.FLY_SPEED);
				Minecraft.getMinecraft().thePlayer.addChatMessage("Set Fly Speed to: "+Fly.FLY_SPEED);
			}
			else{
				Minecraft.getMinecraft().thePlayer.addChatMessage("Can't set values higher than 0.7");
			}
		}
		catch(Exception e){}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Sets player fly speed";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return this.getCommand().concat(" <blocks/second>");
	}

}
