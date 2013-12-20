package net.cheatingessentials.client.command;

import net.cheatingessentials.client.modules.player.Speed;
import net.cheatingessentials.client.modules.render.BlockFinder;
import net.cheatingessentials.config.agce.AGCEConfigurationNG;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

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
		icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Set speed to: "+speedvalue));
	}

}
