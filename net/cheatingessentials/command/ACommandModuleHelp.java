package net.cheatingessentials.command;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.api.Command;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.minecraft.client.Minecraft;

public class ACommandModuleHelp extends Command {

	public ACommandModuleHelp() {
		super("cemh");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		for(Module module : APIModule.instance().modules){
			if(subcommands[0].equalsIgnoreCase(module.getModuleName().replaceAll(" ", ""))){
				Minecraft.getMinecraft().thePlayer.sendChatMessage("Help for module "+module.getModuleName()+": "+module.showHelp());
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
