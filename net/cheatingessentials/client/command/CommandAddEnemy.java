package net.cheatingessentials.client.command;

import java.io.File;

import net.cheatingessentials.config.ConfigurationManager;
import net.cheatingessentials.config.agce.AGCEConfigurationSList;
import net.cheatingessentials.relation.PlayerRelations;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

public class CommandAddEnemy extends CommandBase {

	@Override
	public String getCommandName() {
		return "ceec";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/ceec add <enemy name> or delete <enemy name>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) 
	{
		if(astring[0].equalsIgnoreCase("add"))
		{
			for(String string: PlayerRelations.instance().enemies)
			{
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Added enemy: "+astring[1]));
				PlayerRelations.instance().enemies.add(astring[1]); 
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEEnemies.txt"), PlayerRelations.instance().enemies);
				break;
			}
		}
		if(astring[0].equalsIgnoreCase("delete"))
		{
			for(String string: PlayerRelations.instance().enemies)
			{
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Added enemy: "+astring[1]));
				PlayerRelations.instance().enemies.remove(astring[1]); 
				AGCEConfigurationSList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEEnemies.txt"), PlayerRelations.instance().enemies);
				break;
			}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) 
	{
		return true;
	}
}
