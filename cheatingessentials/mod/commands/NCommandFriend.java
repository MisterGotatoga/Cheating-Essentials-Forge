package cheatingessentials.mod.commands;

import cheatingessentials.mod.external.config.agce.files.AGCEIntegerList;
import cheatingessentials.mod.relationsystem.Friend;
import cheatingessentials.mod.wrapper.Wrapper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class NCommandFriend extends CommandBase {

	@Override
	public String getCommandName() 
	{
		return "cefriend";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) 
	{
		return "Add/remove friend.";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) 
	{
		if(var2[0].equalsIgnoreCase("add"))
		{
			Friend.instance().addFriend(var2[1]);
			AGCEIntegerList.INSTANCE.modify("CE-FriendList.cfg", Friend.instance().friendList);
			Wrapper.INSTANCE.addChatMessage("Added Friend: " + var2[1]);
		}
		
		if(var2[0].equalsIgnoreCase("remove"))
		{
			Friend.instance().removeFriend(var2[1]);
			AGCEIntegerList.INSTANCE.modify("CE-FriendList.cfg", Friend.instance().friendList);
			Wrapper.INSTANCE.addChatMessage("Removed Friend: " + var2[1]);
		}
	}

	@Override
	public int compareTo(Object arg0)
	{
		return 0;
	}

}
