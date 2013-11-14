package common.kodehawa.ce.apicommands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatMessageComponent;

import org.lwjgl.input.Keyboard;

import common.kodehawa.api.console.BaseCommand;
import common.kodehawa.ce.config.KeybindConfiguration;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.man.ModuleManager;

public class ACommandSMKeybind extends BaseCommand {

	public ACommandSMKeybind() {
		super("smkey");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		boolean successful = false;
		if(subcommands[0].equalsIgnoreCase("add")){
			for(AbstractModule m : ModuleManager.instance().avModules){
				if(subcommands[1].equalsIgnoreCase(m.getModuleName().replaceAll(" ", ""))){
					int i = Keyboard.getKeyIndex(subcommands[2].toUpperCase());
					if(i != Keyboard.KEY_NONE){
						successful = true;
						m.setKeybinding(i); 
						Minecraft.getMinecraft().thePlayer.addChatMessage("Setted key: "+m.getKeybind()+"("+subcommands[2]+")"+" for module: "+m.getModuleName());
						KeybindConfiguration.instance().writeKeybindConfig(); 
						break;
					}
				}
			}
		}
		
		if(subcommands[0].equalsIgnoreCase("delete")){
			for(AbstractModule m : ModuleManager.instance().avModules){
				if(subcommands[1].equalsIgnoreCase(m.getModuleName().replaceAll(" ", ""))){
					successful = true;
					m.setKeybinding(0);
					Minecraft.getMinecraft().thePlayer.addChatMessage("Removed key for module: "+m.getModuleName());
					KeybindConfiguration.instance().writeKeybindConfig();
					break;
				}
			}
		}
		if(!successful){
			Minecraft.getMinecraft().thePlayer.addChatMessage("Can't recognize module: "+subcommands[1]+" or subcommand: "+subcommands[0]);
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Change module keys";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return this.getCommand()+" <add/delete> <module> <key>";
	}

}
