package net.cheatingessentials.command;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.api.Command;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

public class ACommandModuleList extends Command {

	public ACommandModuleList() {
		super("ceml");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		for(Module module : APIModule.instance().modules){
			Minecraft.getMinecraft().thePlayer.sendChatMessage("Module: "+module.getModuleName() + " - Key: ["+Keyboard.getKeyName(module.getKeybind())+"]");
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
