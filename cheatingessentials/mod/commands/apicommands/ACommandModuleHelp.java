package cheatingessentials.mod.commands.apicommands;

import cheatingessentials.api.command.Command;
import cheatingessentials.api.module.APICEMod;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.Wrapper;

public class ACommandModuleHelp extends Command {

	public ACommandModuleHelp() {
		super("cemh");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		for(Mod module : APICEMod.INSTANCE.mods){
			if(subcommands[0].equalsIgnoreCase(module.getName().replaceAll(" ", ""))){
				Wrapper.INSTANCE.addChatMessage("Help for module "+module.getName()+": "+module.getDescription());
			}
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Shows avaliable help for a specified module";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return this.getCommand().concat(" <module name>");
	}

}
