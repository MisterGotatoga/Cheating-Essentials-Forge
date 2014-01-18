package cheatingessentials.mod.commands.apicommands;

import net.minecraft.client.Minecraft;
import cheatingessentials.api.command.Command;
import cheatingessentials.api.module.APICEMod;
import cheatingessentials.mod.external.config.agce.files.AGCEIntegerList;
import cheatingessentials.mod.modulesystem.classes.XRay;
import cheatingessentials.mod.util.CEUtility;
import cheatingessentials.mod.wrapper.Wrapper;

import com.ibm.icu.impl.duration.impl.Utils;

public class ACommandXray extends Command {

	public ACommandXray() {
		super("cexray");
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		if(subcommands[0].equalsIgnoreCase("add")){
			XRay.xrayList2.add(subcommands[1]);
			XRay.addDefaultList();
			Wrapper.INSTANCE.addChatMessage("Added ID from X-Ray list: "+subcommands[1]);
			CEUtility.removeDupes(XRay.xrayList2);
			AGCEIntegerList.INSTANCE.modify("CEXrayBlocks.txt", XRay.xrayList2);
			CEUtility.removeDupes(XRay.xrayList2);
			APICEMod.INSTANCE.call(XRay.class).reset();
		}
		
		else if(subcommands[0].equalsIgnoreCase("delete")){
			XRay.xrayList2.remove(subcommands[1]);
			XRay.removeDefaultList();
			XRay.addDefaultList();
			Wrapper.INSTANCE.addChatMessage("Added ID from X-Ray list: "+subcommands[1]);
			CEUtility.removeDupes(XRay.xrayList2);
			AGCEIntegerList.INSTANCE.modify("CEXrayBlocks.txt", XRay.xrayList2);
			CEUtility.removeDupes(XRay.xrayList2);
			APICEMod.INSTANCE.call(XRay.class).reset();
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
