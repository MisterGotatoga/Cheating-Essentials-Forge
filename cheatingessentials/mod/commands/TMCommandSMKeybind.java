package cheatingessentials.mod.commands;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.APICEMod;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.external.config.manual.KeybindConfiguration;
import cheatingessentials.mod.wrapper.Wrapper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class TMCommandSMKeybind extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "smkey";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		// TODO Auto-generated method stub
		return "Change module keybinding (add/delete)";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		// TODO Auto-generated method stub
		boolean successful = false;
		if(var2[0].equalsIgnoreCase("add")){
			for(Mod m : APICEMod.INSTANCE.mods){
				if(var2[1].equalsIgnoreCase(m.getName().replaceAll(" ", ""))){
					int i = Keyboard.getKeyIndex(var2[2].toUpperCase());
					if(i != Keyboard.KEY_NONE){
						successful = true;
						m.setKeybinding(i); 
						Wrapper.INSTANCE.addChatMessage("Setted key: "+m.getKeybind()+"("+var2[2]+")"+" for module: "+m.getName());
						KeybindConfiguration.instance().writeKeybindConfig(); 
						break;
					}
				}
			}
		}
		
		if(var2[0].equalsIgnoreCase("delete")){
			for(Mod module : APICEMod.INSTANCE.mods){
				if(var2[1].equalsIgnoreCase(module.getName().replaceAll(" ", ""))){
					successful = true;
					module.setKeybinding(0);
					Wrapper.INSTANCE.addChatMessage("Removed key for module: "+module.getName());
					KeybindConfiguration.instance().writeKeybindConfig();
					break;
				}
			}
		}
		if(!successful){
			Wrapper.INSTANCE.addChatMessage("Can't recognize module: "+var2[1]+" or subcommand: "+var2[0]);
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean canCommandSenderUseCommand(ICommandSender var1)
	{
		return true;
	}

}
