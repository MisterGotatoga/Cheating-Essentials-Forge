package cheatingessentials.mod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import cheatingessentials.mod.external.config.agce.files.AGCEIntegerList;
import cheatingessentials.mod.relationsystem.Enemy;
import cheatingessentials.mod.relationsystem.Friend;
import cheatingessentials.mod.wrapper.Wrapper;

public class NCommandEnemy extends CommandBase {

	@Override
	public String getCommandName()
	{
		return "ceenemy";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) 
	{
		return "Add/remove enemy";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) 
	{
		if(var2[0].equalsIgnoreCase("add"))
		{
			Enemy.instance().addEnemy(var2[1]);
			AGCEIntegerList.INSTANCE.modify("CE-EnemyList.cfg", Friend.instance().friendList);
			Wrapper.INSTANCE.addChatMessage("Added Enemy: " + var2[1]);
		}
		
		if(var2[0].equalsIgnoreCase("remove"))
		{
			Enemy.instance().removeEnemy(var2[1]);
			AGCEIntegerList.INSTANCE.modify("CE-EnemyList.cfg", Friend.instance().friendList);
			Wrapper.INSTANCE.addChatMessage("Removed Enemy: " + var2[1]);
		}
	}

	@Override
	public int compareTo(Object o)
	{
		return 0;
	}

}
