package common.kodehawa.ce.apicommands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatMessageComponent;
import common.kodehawa.api.console.BaseCommand;
import common.kodehawa.ce.config.AGCEConfigurationIList;
import common.kodehawa.ce.module.classes.XRay;
import common.kodehawa.ce.module.man.ModuleManager;
import common.kodehawa.ce.util.Utils;

public class ACommandXray extends BaseCommand {

	public ACommandXray() {
		super("cexray");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		if(subcommands[0].equalsIgnoreCase("add")){
			Integer id = Integer.parseInt(subcommands[1]);
			XRay.xrayList2.add((Integer)id);
			XRay.addDefaultList();
			Minecraft.getMinecraft().thePlayer.addChatMessage("Added ID from X-Ray list: "+id);
			Utils.instance().removeDupes(XRay.xrayList2);
			AGCEConfigurationIList.instance.modify("CEXrayBlocks.txt", XRay.xrayList2);
			Utils.instance().removeDupes(XRay.xrayList2);
			ModuleManager.instance().getModuleClass(XRay.class).reset();
		}
		
		else if(subcommands[0].equalsIgnoreCase("delete")){
			Integer id = Integer.parseInt(subcommands[1]);
			XRay.xrayList2.remove(XRay.xrayList2.indexOf((Integer)id));
			Utils.instance().removeDupes(XRay.xrayList2);
			XRay.removeDefaultList();
			XRay.addDefaultList();
			Utils.instance().removeDupes(XRay.xrayList2);
			Minecraft.getMinecraft().thePlayer.addChatMessage("Removed ID from X-Ray list: "+id);
			AGCEConfigurationIList.instance.modify("CEXrayBlocks.txt", XRay.xrayList2);
			ModuleManager.instance().getModuleClass(XRay.class).reset();
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
