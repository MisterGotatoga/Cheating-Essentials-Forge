package net.cheatingessentials.client.command;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.config.KeybindConfiguration;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import org.lwjgl.input.Keyboard;

public class CommandSMKeybind extends CommandBase {

	@Override
	public String getCommandName() {
		return "smkey";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/smkey add <module> <key> or delete <module> <key>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		boolean successful = false;
			if(astring[0].equalsIgnoreCase("add")){
				for(Module m : APIModule.instance().modules){
					if(astring[1].equalsIgnoreCase(m.getModuleName().replaceAll(" ", ""))){
						int i = Keyboard.getKeyIndex(astring[2].toUpperCase());
						if(i != Keyboard.KEY_NONE){
							successful = true;
							m.setKeybinding(i); 
							Minecraft.getMinecraft().thePlayer.sendChatMessage("Setted key: "+m.getKeybind()+"("+astring[2]+")"+" for module: "+m.getModuleName());
							KeybindConfiguration.instance().writeKeybindConfig(); 
							break;
						}
					}
				}
			}
			
			if(astring[0].equalsIgnoreCase("delete")){
				for(Module m : APIModule.instance().modules){
					if(astring[1].equalsIgnoreCase(m.getModuleName().replaceAll(" ", ""))){
						successful = true;
						m.setKeybinding(0);
						Minecraft.getMinecraft().thePlayer.sendChatMessage("Removed key for module: "+m.getModuleName());
						KeybindConfiguration.instance().writeKeybindConfig();
						break;
					}
				}
			}
			if(!successful){
				Minecraft.getMinecraft().thePlayer.sendChatMessage("Can't recognize module: "+astring[1]+" or subcommand: "+astring[0]);
			}
		}
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
