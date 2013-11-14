package common.kodehawa.ce.apicommands;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import common.kodehawa.api.console.BaseCommand;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.man.ModuleManager;

public class ACommandModuleList extends BaseCommand {

	public ACommandModuleList() {
		super("ceml");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		for(AbstractModule module : ModuleManager.instance().avModules){
			Minecraft.getMinecraft().thePlayer.addChatMessage("Module: "+module.getModuleName() + " - Key: ["+Keyboard.getKeyName(module.getKeybind())+"]");
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "List all modules";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return null;
	}

}
