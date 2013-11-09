package common.kodehawa.ce.commands;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;
import common.kodehawa.ce.config.AGCEConfigurationIList;
import common.kodehawa.ce.config.ConfigurationManager;
import common.kodehawa.ce.module.classes.BlockFinder;
import common.kodehawa.ce.module.classes.XRay;
import common.kodehawa.ce.module.man.ModuleManager;
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
			AGCEConfigurationIList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEXrayBlocks.txt"), XRay.xrayList2);
			Utils.instance().removeDupes(XRay.xrayList2);
			ModuleManager.instance().getModuleClass(XRay.class).reset();
		}
		
		else if(astring[0].equalsIgnoreCase("delete")){
			Integer id = Integer.parseInt(astring[1]);
			XRay.xrayList2.remove((Integer)id);
			Utils.instance().removeDupes(XRay.xrayList2);
			XRay.removeDefaultList();
			Utils.instance().removeDupes(XRay.xrayList2);
			icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Removed ID from X-Ray list: "+id));
			AGCEConfigurationIList.instance.modify(new File(Minecraft.getMinecraft().mcDataDir, "/config/Cheating Essentials/CEXrayBlocks.txt"), XRay.xrayList2);
			ModuleManager.instance().getModuleClass(XRay.class).reset();
		}
	}
}
