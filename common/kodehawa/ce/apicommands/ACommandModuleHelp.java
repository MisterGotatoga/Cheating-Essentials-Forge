package common.kodehawa.ce.apicommands;

import net.minecraft.client.Minecraft;

import common.kodehawa.api.console.BaseCommand;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.man.ModuleManager;

public class ACommandModuleHelp extends BaseCommand {

	public ACommandModuleHelp() {
		super("cemh");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		for(AbstractModule module : ModuleManager.instance().avModules){
			if(subcommands[0].equalsIgnoreCase(module.getModuleName().replaceAll(" ", ""))){
				Minecraft.getMinecraft().thePlayer.addChatMessage("Help for module "+module.getModuleName()+": "+module.showHelp());
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
