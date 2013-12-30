package net.cheatingessentials.command;

import net.cheatingessentials.api.Command;
import net.cheatingessentials.client.modules.player.Fly;
import net.cheatingessentials.config.agce.AGCEConfigurationNG;
import net.minecraft.client.Minecraft;

public class ACommandFlySpeed extends Command {

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
				Minecraft.getMinecraft().thePlayer.sendChatMessage("Set Fly Speed to: "+Fly.FLY_SPEED);
			}
			else{
				Minecraft.getMinecraft().thePlayer.sendChatMessage("Can't set values higher than 0.7");
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
