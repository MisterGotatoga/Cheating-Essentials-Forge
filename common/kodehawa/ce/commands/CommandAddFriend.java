package common.kodehawa.ce.commands;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

import common.kodehawa.ce.config.AGCEConfigurationSList;
import common.kodehawa.ce.config.ConfigManager;

public class CommandAddFriend extends CommandBase {

	@Override
	public String getCommandName() {
		return "cefriend";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/cefriend add <friend name> or delete <friend name>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(astring[0].equalsIgnoreCase("add")){
			for(String string: ConfigManager.instance().friends){
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Added friend: "+astring[1]));
				ConfigManager.instance().friends.add(astring[1]);
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEFriends.txt"), ConfigManager.instance().friends); break;
			}
		}
		if(astring[0].equalsIgnoreCase("delete")){
			for(String string: ConfigManager.instance().friends){
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Removed friend: "+astring[1]));
				ConfigManager.instance().friends.remove(astring[1]);
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEFriends.txt"), ConfigManager.instance().friends); break;
			}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}
}
