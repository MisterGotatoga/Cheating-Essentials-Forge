package cheatingessentials.mod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import cheatingessentials.api.module.APICEMod;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.Wrapper;

public class NCommandMT extends CommandBase {

	@Override
	public String getCommandName() {
		return "mt";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "Example usage: /mt cheatingessentials:<mod name, without spaces>";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) 
	{
		for(Mod mod : APICEMod.INSTANCE.mods)
		{
			String[] s0 = var2[0].split(":");
			if(s0[0].equals("cheatingessentials"))
			{
				//System.out.println(s0[1]);
				//System.out.println(mod.getName().toLowerCase().replaceAll(" ", ""));
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
	public int compareTo(Object arg0) {
		return 0;
	}
	
    public boolean canCommandSenderUseCommand(ICommandSender var1)
    {
    	return true;
    }

}
