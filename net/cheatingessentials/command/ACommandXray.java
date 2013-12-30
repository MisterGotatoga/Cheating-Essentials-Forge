package net.cheatingessentials.command;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Command;
import net.cheatingessentials.client.modules.world.XRay;
import net.cheatingessentials.config.agce.AGCEConfigurationIList;
import net.cheatingessentials.util.Utils;
import net.minecraft.client.Minecraft;

public class ACommandXray extends Command {

	public ACommandXray() {
		super("cexray");
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		if(subcommands[0].equalsIgnoreCase("add")){
			Integer id = Integer.parseInt(subcommands[1]);
			XRay.xrayList2.add((Integer)id);
			XRay.addDefaultList();
			Minecraft.getMinecraft().thePlayer.sendChatMessage("Added ID from X-Ray list: "+id);
			Utils.instance().removeDupes(XRay.xrayList2);
			AGCEConfigurationIList.instance.modify("CEXrayBlocks.txt", XRay.xrayList2);
			Utils.instance().removeDupes(XRay.xrayList2);
			APIModule.instance().getModuleClass(XRay.class).reset();
		}
		
		else if(subcommands[0].equalsIgnoreCase("delete")){
			Integer id = Integer.parseInt(subcommands[1]);
			XRay.xrayList2.remove(XRay.xrayList2.indexOf((Integer)id));
			Utils.instance().removeDupes(XRay.xrayList2);
			XRay.removeDefaultList();
			XRay.addDefaultList();
			Utils.instance().removeDupes(XRay.xrayList2);
			Minecraft.getMinecraft().thePlayer.sendChatMessage("Removed ID from X-Ray list: "+id);
			AGCEConfigurationIList.instance.modify("CEXrayBlocks.txt", XRay.xrayList2);
			APIModule.instance().getModuleClass(XRay.class).reset();
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Adds/removes X-Ray blocks";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return this.getCommand()+" <add/delete> <block id>";
	}

}
