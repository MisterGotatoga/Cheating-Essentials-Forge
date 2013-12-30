package net.cheatingessentials.command;

import net.cheatingessentials.api.Command;
import net.cheatingessentials.client.modules.render.BlockFinder;
import net.cheatingessentials.config.agce.AGCEConfigurationIList;
import net.minecraft.client.Minecraft;

public class ACommandBlockESP extends Command {

	public ACommandBlockESP() {
		super("cebe");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] astring) {
		String answer = null;
		boolean modify = false;
		String[] split;
		switch (astring[0].toLowerCase()) {
		case "add":
			split = astring[1].split(":");
			if(split.length == 1){
				int id = Integer.parseInt(astring[1]);
				BlockFinder.instance.addBlock(id);
				answer = "Added to CE BlockESP list: "+astring[1];
				modify = true;
			}else if(split.length == 2){
				int id = Integer.parseInt(split[0]);
				int meta = Integer.parseInt(split[1]);
				BlockFinder.instance.addBlock(id, meta);
				answer = "Added to CE BlockESP list: "+astring[1];
				modify = true;
			}
			break;
			
		case "remove":
			split = astring[1].split(":");
			if(split.length == 1){
				int id = Integer.parseInt(astring[1]);
				BlockFinder.instance.removeBlock(id);
				answer = "Removed from CE BlockESP list: "+astring[1];
				modify = true;
			}else if(split.length == 2){
				int id = Integer.parseInt(split[0]);
				int meta = Integer.parseInt(split[1]);
				BlockFinder.instance.removeBlock(id, meta);
				answer = "Removed from CE BlockESP list: "+astring[1];
				modify = true;
			}
			break;
			
		case "removeall":
			BlockFinder.instance.removeAll();
			answer = "CE BlockESP list cleared";
			modify = true;
			break;
			
		case "list":
			answer = BlockFinder.instance.list();
			break;
			
		default:
			answer = "Incorrect command usage!";
			break;
		}
		if(modify)
			AGCEConfigurationIList.instance.modify("CEBlockESPList.txt", BlockFinder.instance.idEspList);
		if(answer != null)
			Minecraft.getMinecraft().thePlayer.sendChatMessage(answer);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Adds / removes blocks from Block Finder list.";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return this.getCommand()+" <add/remove> <block id>";
	}

}
