package cheatingessentials.mod.commands.apicommands;

import net.minecraft.client.Minecraft;
import cheatingessentials.api.command.Command;
import cheatingessentials.mod.external.config.agce.files.AGCEIntegerList;
import cheatingessentials.mod.modulesystem.classes.BlockFinder;
import cheatingessentials.mod.wrapper.Wrapper;

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
		if(astring[0].equalsIgnoreCase("add"))
		{
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
		}			
		else if(astring[0].equalsIgnoreCase("remove"))
		{
			split = astring[1].split(":");
			if(split.length == 1){
				int id = Integer.parseInt(astring[1]);
				BlockFinder.instance.removeBlock(id);
				answer = "Removed from CE BlockESP list: "+astring[1];
				modify = true;
			}
			else if(split.length == 2){
				int id = Integer.parseInt(split[0]);
				int meta = Integer.parseInt(split[1]);
				BlockFinder.instance.removeBlock(id, meta);
				answer = "Removed from CE BlockESP list: "+astring[1];
				modify = true;
			}
		}			
		else if(astring[0].equalsIgnoreCase("removeall"))
		{
			BlockFinder.instance.removeAll();
			answer = "CE BlockESP list cleared";
			modify = true;
		}			
		else if(astring[0].equalsIgnoreCase("list"))
		{
			answer = BlockFinder.instance.list();
		}			
		else
		{
			answer = "Incorrect command usage!";
		}
		if(modify)
			AGCEIntegerList.INSTANCE.modify("CEBlockESPList.txt", BlockFinder.instance.idEspList);
		if(answer != null)
			Wrapper.INSTANCE.addChatMessage(answer);
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
