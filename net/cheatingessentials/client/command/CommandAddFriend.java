package net.cheatingessentials.client.command;

import java.io.File;

import net.cheatingessentials.config.agce.AGCEConfigurationSList;
import net.cheatingessentials.relation.PlayerRelations;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandAddFriend extends CommandBase {

	@Override
	public String getCommandName() {
		return "cefc";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/cefc add <friend name> or delete <friend name>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(astring[0].equalsIgnoreCase("add")){
			for(String string: PlayerRelations.instance().friends){
				Minecraft.getMinecraft().thePlayer.sendChatMessage("Added friend: "+astring[1]);
				PlayerRelations.instance().friends.add(astring[1]);
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEFriends.txt"), PlayerRelations.instance().friends); break;
			}
		}
		if(astring[0].equalsIgnoreCase("delete")){
			for(String string: PlayerRelations.instance().friends){
				Minecraft.getMinecraft().thePlayer.sendChatMessage("Removed friend: "+astring[1]);
				PlayerRelations.instance().friends.remove(astring[1]);
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEFriends.txt"), PlayerRelations.instance().friends); break;
			}
		}
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
