package common.kodehawa.ce.apicommands;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatMessageComponent;
import common.kodehawa.api.console.BaseCommand;
import common.kodehawa.ce.config.AGCEConfigurationSList;
import common.kodehawa.ce.relations.PlayerRelations;

public class ACommandFriend extends BaseCommand {

	public ACommandFriend() {
		super("cefc");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		if(subcommands[0].equalsIgnoreCase("add")){
			for(String string: PlayerRelations.instance().friends){
				Minecraft.getMinecraft().thePlayer.addChatMessage("Added friend: "+subcommands[1]);
				PlayerRelations.instance().friends.add(subcommands[1]);
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEFriends.txt"), PlayerRelations.instance().friends); break;
			}
		}
		if(subcommands[0].equalsIgnoreCase("delete")){
			for(String string: PlayerRelations.instance().friends){
				Minecraft.getMinecraft().thePlayer.addChatMessage("Removed friend: "+subcommands[1]);
				PlayerRelations.instance().friends.remove(subcommands[1]);
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEFriends.txt"), PlayerRelations.instance().friends); break;
			}
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Adds / removes friends from list.";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return this.getCommand().concat(" <add/delete> <player name>");
	}

}
