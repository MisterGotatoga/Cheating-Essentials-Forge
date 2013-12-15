package net.cheatingessentials.client.command;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

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
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Help for module "+module.getModuleName()+": "+module.showHelp()));
			}
		}
	}
	
    public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender) {
        return true;
    }

}
