package net.cheatingessentials.client.command;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandModuleHelp extends CommandBase {

	@Override
	public String getCommandName() {
		return "cemh";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/cemh <name of the mod>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		for(Module module : APIModule.instance().modules){
			if(astring[0].equalsIgnoreCase(module.getModuleName().replaceAll(" ", ""))){
				Minecraft.getMinecraft().thePlayer.sendChatMessage("Help for module "+module.getModuleName()+": "+module.showHelp());
			}
		}
	}
	
    public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender) {
        return true;
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
