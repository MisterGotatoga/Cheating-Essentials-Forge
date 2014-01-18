package cheatingessentials.mod.commands.apicommands;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.command.Command;
import cheatingessentials.api.module.APICEMod;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.Wrapper;

public class ACommandModuleList extends Command {

	public ACommandModuleList() {
		super("ceml");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		for(Mod module : APICEMod.INSTANCE.mods){
			Wrapper.INSTANCE.addChatMessage("Module: "+module.getName() + " - Key: ["+Keyboard.getKeyName(module.getKeybind())+"]");
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
