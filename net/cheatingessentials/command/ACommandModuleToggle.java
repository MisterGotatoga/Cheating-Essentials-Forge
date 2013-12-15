package net.cheatingessentials.command;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.api.Command;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.cheatingessentials.config.ModuleStateConfiguration;
import net.minecraft.client.Minecraft;

public class ACommandModuleToggle extends Command
{

	public ACommandModuleToggle() 
	{
		super("module");
	}

	@Override
	public void runCommand(String s, String[] subcommands)
	{
		for(Module module : APIModule.instance().modules){
			if(module.getModuleName().replace(" ", "").equalsIgnoreCase(subcommands[0])){
				module.toggle(); 
				Minecraft.getMinecraft().thePlayer.addChatMessage("Toggled Module: "+module.getModuleName()+" -- Module State: "+ (module.isActive() ? ("Active") : ("Disabled") ));
				break;
			}
		}
	}

	@Override
	public String getDescription()
	{
		return "Toggles a module";
	}

	@Override
	public String getSyntax() 
	{
		return this.getCommand()+" <module name>";
	}

}
