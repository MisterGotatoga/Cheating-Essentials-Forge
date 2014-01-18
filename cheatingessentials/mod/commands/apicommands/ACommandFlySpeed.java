package cheatingessentials.mod.commands.apicommands;

import net.minecraft.client.Minecraft;
import cheatingessentials.api.command.Command;
import cheatingessentials.mod.external.config.agce.files.AGCEGeneric;
import cheatingessentials.mod.modulesystem.classes.Fly;
import cheatingessentials.mod.wrapper.Wrapper;

public class ACommandFlySpeed extends Command {

	public ACommandFlySpeed() {
		super("flyspeed");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] subcommands) {
		// TODO Auto-generated method stub
		float string = Float.parseFloat(subcommands[0]);
		Fly.FLY_SPEED = string;
		try{
			if(string < 0.7F){
				Minecraft.getMinecraft().thePlayer.capabilities.setFlySpeed(Fly.FLY_SPEED);
				AGCEGeneric.INSTANCE.modify("CEFlySpeed.txt", Fly.FLY_SPEED);
				Wrapper.INSTANCE.addChatMessage("Set Fly Speed to: "+Fly.FLY_SPEED);
			}
			else{
				Wrapper.INSTANCE.addChatMessage("Can't set values higher than 0.7");
			}
		}
		catch(Exception e){}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Sets player fly speed";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return this.getCommand().concat(" <blocks/second>");
	}

}
