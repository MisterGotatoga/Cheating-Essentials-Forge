package net.cheatingessentials.client.command;

import net.cheatingessentials.client.modules.player.Speed;
import net.cheatingessentials.config.agce.AGCEConfigurationNG;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandSpeedValue extends CommandBase {

	@Override
	public String getCommandName() {
		return "cesv";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/cesv <speed value>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		Double speedvalue = Double.parseDouble(astring[0]);
		Speed.SPEED_VALUE = speedvalue;
		AGCEConfigurationNG.instance.modify("CESpeedValue.txt", speedvalue);
		Minecraft.getMinecraft().thePlayer.sendChatMessage("Set speed to: "+speedvalue);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
