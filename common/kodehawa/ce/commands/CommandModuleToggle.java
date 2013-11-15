package common.kodehawa.ce.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;
import common.kodehawa.ce.config.ModuleStateConfiguration;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.man.ModuleManager;

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
		for(AbstractModule module : ModuleManager.instance().avModules){
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
