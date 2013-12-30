package net.cheatingessentials.command;

import java.io.File;

import net.cheatingessentials.api.Command;
import net.cheatingessentials.config.agce.AGCEConfigurationSList;
import net.cheatingessentials.relation.PlayerRelations;
import net.minecraft.client.Minecraft;

public class ACommandEnemy extends Command {

	public ACommandEnemy() {
		super("ceec");
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		if(subcommands[0].equalsIgnoreCase("add"))
		{
			for(String string: PlayerRelations.instance().enemies)
			{
				Minecraft.getMinecraft().thePlayer.sendChatMessage("Added enemy: "+subcommands[1]);
				PlayerRelations.instance().enemies.add(subcommands[1]); 
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEEnemies.txt"), PlayerRelations.instance().enemies);
				break;
			}
		}
		if(subcommands[0].equalsIgnoreCase("delete"))
		{
			for(String string: PlayerRelations.instance().enemies)
			{
				Minecraft.getMinecraft().thePlayer.sendChatMessage("Added enemy: "+subcommands[1]);
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
