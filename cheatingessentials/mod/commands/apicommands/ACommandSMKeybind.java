package cheatingessentials.mod.commands.apicommands;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import ch.epfl.lamp.compiler.msil.Module;
import cheatingessentials.api.command.Command;
import cheatingessentials.api.module.APICEMod;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.external.config.manual.KeybindConfiguration;
import cheatingessentials.mod.wrapper.Wrapper;

public class ACommandSMKeybind extends Command {

	public ACommandSMKeybind() {
		super("smkey");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		boolean successful = false;
		if(subcommands[0].equalsIgnoreCase("add")){
			for(Mod m : APICEMod.INSTANCE.mods){
				if(subcommands[1].equalsIgnoreCase(m.getName().replaceAll(" ", ""))){
					int i = Keyboard.getKeyIndex(subcommands[2].toUpperCase());
					if(i != Keyboard.KEY_NONE){
						successful = true;
						m.setKeybinding(i); 
						Wrapper.INSTANCE.addChatMessage("Setted key: "+m.getKeybind()+"("+subcommands[2]+")"+" for module: "+m.getName());
						KeybindConfiguration.instance().writeKeybindConfig(); 
						break;
					}
				}
			}
		}
		
		if(subcommands[0].equalsIgnoreCase("delete")){
			for(Mod module : APICEMod.INSTANCE.mods){
				if(subcommands[1].equalsIgnoreCase(module.getName().replaceAll(" ", ""))){
					successful = true;
					module.setKeybinding(0);
					Wrapper.INSTANCE.addChatMessage("Removed key for module: "+module.getName());
					KeybindConfiguration.instance().writeKeybindConfig();
					break;
				}
			}
		}
		if(!successful){
			Wrapper.INSTANCE.addChatMessage("Can't recognize module: "+subcommands[1]+" or subcommand: "+subcommands[0]);
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
