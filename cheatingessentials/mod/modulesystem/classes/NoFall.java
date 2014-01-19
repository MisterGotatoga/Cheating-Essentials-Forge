package cheatingessentials.mod.modulesystem.classes;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;

public class NoFall extends Mod {

	public NoFall()
	{
		super(ModuleCategories.PLAYER);
		this.setKeybinding(Keyboard.KEY_V);
	}
	
	@Override
	public String getName(){
		return "No Fall";
	}
	
	@Override
	public String getDescription(){
		return "Avoid player fall damage calculations and removes player fall damage itself";
	}
	
	@Override
	public void onTick(){
		/*Wrapper.INSTANCE.player().sendQueue.addToSendQueue(new Packet13PlayerLookMove(player().motionX, -999.0D, -999.0D, player().motionZ,
				player().rotationYaw, player().rotationPitch, !player().onGround));*/
	}
}
