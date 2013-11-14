package common.kodehawa.ce.commands;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

import common.kodehawa.ce.config.AGCEConfigurationIList;
import common.kodehawa.ce.module.classes.BlockFinder;

public class CommandBlockESP extends CommandBase {

	@Override
	public String getCommandName() 
	{
		return "cebe";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/cebe add/remove block id";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) 
	{
		if(astring[0].equalsIgnoreCase("add")){
			BlockFinder.espList.add(Integer.parseInt(astring[1]));
			AGCEConfigurationIList.instance.modify("CEBlockESPList.txt", BlockFinder.espList);
		    icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Added to CE BlockESP list: "+astring[1]));
		}
		if(astring[0].equalsIgnoreCase("remove")){
			BlockFinder.espList.remove((Integer)Integer.parseInt(astring[1]));
			AGCEConfigurationIList.instance.modify("CEBlockESPList.txt", BlockFinder.espList);
		    icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Removed from CE BlockESP list: "+astring[1]));
		}
	}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) 
	{
		return true;
	}

}
