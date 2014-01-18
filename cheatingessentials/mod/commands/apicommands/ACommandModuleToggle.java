package cheatingessentials.mod.commands.apicommands;

import cheatingessentials.api.command.Command;
import cheatingessentials.api.module.APICEMod;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.Wrapper;

public class ACommandModuleToggle extends Command
{

	public ACommandModuleToggle() 
	{
		super("mt");
	}

	@Override
	public void runCommand(String s, String[] subcommands)
	{
		for(Mod mod : APICEMod.INSTANCE.mods)
		{
			String[] s0 = subcommands[0].split(":");
			if(s0[0].equals("cheatingessentials"))
			{
				if(mod.getName().toLowerCase().replaceAll(" ", "").equalsIgnoreCase(s0[1]))
				{
					mod.toggle();
					Wrapper.INSTANCE.addChatMessage("[Cheating Essentials] Succefully toggled module via command: "+mod.getName()+" with status: "+mod.isActive());
					break;
				}
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
