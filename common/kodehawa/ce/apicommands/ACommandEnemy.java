package common.kodehawa.ce.apicommands;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatMessageComponent;
import common.kodehawa.api.console.BaseCommand;
import common.kodehawa.ce.config.AGCEConfigurationSList;
import common.kodehawa.ce.relations.PlayerRelations;

public class ACommandEnemy extends BaseCommand {

	public ACommandEnemy() {
		super("ceec");
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		if(subcommands[0].equalsIgnoreCase("add"))
		{
			for(String string: PlayerRelations.instance().enemies)
			{
				Minecraft.getMinecraft().thePlayer.addChatMessage("Added enemy: "+subcommands[1]);
				PlayerRelations.instance().enemies.add(subcommands[1]); 
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEEnemies.txt"), PlayerRelations.instance().enemies);
				break;
			}
		}
		if(subcommands[0].equalsIgnoreCase("delete"))
		{
			for(String string: PlayerRelations.instance().enemies)
			{
				Minecraft.getMinecraft().thePlayer.addChatMessage("Added enemy: "+subcommands[1]);
				PlayerRelations.instance().enemies.remove(subcommands[1]); 
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEEnemies.txt"), PlayerRelations.instance().enemies);
				break;
			}
		}
	}

	@Override
	public String getDescription() {
		return "Adds/removes a enemy from list";
	}

	@Override
	public String getSyntax() {
		return this.getCommand().concat(" <add/delete> <player name>");
	}

}
