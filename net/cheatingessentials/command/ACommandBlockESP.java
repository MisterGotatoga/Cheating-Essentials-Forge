package net.cheatingessentials.command;

import net.cheatingessentials.api.Command;
import net.cheatingessentials.client.modules.classes.BlockFinder;
import net.cheatingessentials.config.agce.AGCEConfigurationIList;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatMessageComponent;

public class ACommandBlockESP extends Command {

	public ACommandBlockESP() {
		super("cebe");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		if(subcommands[0].equalsIgnoreCase("add")){
			BlockFinder.espList.add(Integer.parseInt(subcommands[1]));
			AGCEConfigurationIList.instance.modify("CEBlockESPList.txt", BlockFinder.espList);
		    Minecraft.getMinecraft().thePlayer.addChatMessage("Added to CE BlockESP list: "+subcommands[1]);
		}
		if(subcommands[0].equalsIgnoreCase("remove")){
			BlockFinder.espList.remove((Integer)Integer.parseInt(subcommands[1]));
			AGCEConfigurationIList.instance.modify("CEBlockESPList.txt", BlockFinder.espList);
			Minecraft.getMinecraft().thePlayer.addChatMessage("Removed from CE BlockESP list: "+subcommands[1]);
		}
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
