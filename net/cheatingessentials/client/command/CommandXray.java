package net.cheatingessentials.client.command;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.client.modules.world.XRay;
import net.cheatingessentials.config.agce.AGCEConfigurationIList;
import net.cheatingessentials.util.Utils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

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
		/*if(astring[0].equalsIgnoreCase("add")){
			Integer id = Integer.parseInt(astring[1]);
			XRay.xrayList2.add((Integer)id);
			XRay.addDefaultList();
			icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Added ID from X-Ray list: "+id));
			Utils.instance().removeDupes(XRay.xrayList2);
			AGCEConfigurationIList.instance.modify("CEXrayBlocks.txt", XRay.xrayList2);
			Utils.instance().removeDupes(XRay.xrayList2);
			APIModule.instance().getModuleClass(XRay.class).reset();
		}
		
		else if(astring[0].equalsIgnoreCase("delete")){
			Integer id = Integer.parseInt(astring[1]);
			XRay.xrayList2.remove(XRay.xrayList2.indexOf((Integer)id));
			Utils.instance().removeDupes(XRay.xrayList2);
			XRay.removeDefaultList();
			XRay.addDefaultList();
			Utils.instance().removeDupes(XRay.xrayList2);
			icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Removed ID from X-Ray list: "+id));
			AGCEConfigurationIList.instance.modify("CEXrayBlocks.txt", XRay.xrayList2);
			APIModule.instance().getModuleClass(XRay.class).reset();
		}*/
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
