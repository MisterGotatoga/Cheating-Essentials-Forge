package net.cheatingessentials.client.command;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

public class CommandModuleToggle extends CommandBase {

	@Override
	public String getCommandName() {
		return "module";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/module <module name to enable>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		for(Module module : APIModule.instance().modules){
			if(module.getModuleName().replace(" ", "").equalsIgnoreCase(astring[0])){
				module.toggle(); 
				icommandsender.sendChatToPlayer(ChatMessageComponent.createFromText("Toggled Module: "+module.getModuleName()+" -- Module State: "+ (module.isActive() ? ("Active") : ("Disabled") )));
				break;
			}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}
}
