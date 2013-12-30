package net.cheatingessentials.client.command;

import java.util.List;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import org.lwjgl.input.Keyboard;

public class CommandModuleList extends CommandBase {

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "modulelist";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/modulelist";
	}

	@Override
	public List getCommandAliases() {
		return null;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		for(Module module : APIModule.instance().modules){
			Minecraft.getMinecraft().thePlayer.sendChatMessage("Module: "+module.getModuleName() + " - Key: ["+Keyboard.getKeyName(module.getKeybind())+"]");
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}
}
