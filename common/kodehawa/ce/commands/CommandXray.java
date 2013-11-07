package common.kodehawa.ce.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;
import common.kodehawa.ce.module.classes.XRay;
import common.kodehawa.ce.module.man.ModuleManager;
import common.kodehawa.ce.util.ConfigManager;
import common.kodehawa.ce.util.Utils;

public class CommandXray extends CommandBase {

	@Override
	public String getCommandName() 
	{
		return "cexray";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/cexray add <blockid> or delete <blockid>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) 
	{
		if(astring[0].equalsIgnoreCase("add")){
			Integer id = Integer.parseInt(astring[1]);
			XRay.xrayList2.add((Integer)id);
			XRay.addDefaultList();
			icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Added ID from X-Ray list: "+id));
			Utils.instance().removeDupes(XRay.xrayList2);
			ConfigManager.instance().writeXrayConfig();
			Utils.instance().removeDupes(XRay.xrayList2);
			ModuleManager.instance().getModuleClass(XRay.class).reset();
		}
		
		else if(astring[0].equalsIgnoreCase("delete")){
			Integer id = Integer.parseInt(astring[1]);
			XRay.xrayList2.remove(id);
			XRay.removeDefaultList();
			icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Removed ID from X-Ray list: "+id));
			ConfigManager.instance().writeXrayConfig();
			ModuleManager.instance().getModuleClass(XRay.class).reset();

		}
	}
}
