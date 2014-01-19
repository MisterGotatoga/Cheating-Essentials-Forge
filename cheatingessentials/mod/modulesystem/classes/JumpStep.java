package cheatingessentials.mod.modulesystem.classes;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class JumpStep extends Mod {

	public JumpStep()
	{
		super(ModuleCategories.MOVEMENT);
	}
	
	public String getName(){
		return "Jump Step";
	}
	
	@Override
	public String getDescription(){
		return "Does a step, but jumping, owo :)";
	}
	
	public void onPlayerUpdate()
	{
		if(Wrapper.INSTANCE.player().isCollidedHorizontally && Keyboard.isKeyDown(Wrapper.INSTANCE.minecraft().gameSettings.keyBindForward.func_151463_i()) && !Wrapper.INSTANCE.player().handleLavaMovement() && !Wrapper.INSTANCE.player().handleWaterMovement() && !Wrapper.INSTANCE.player().isOnLadder() && Wrapper.INSTANCE.player().onGround)
		{
			Wrapper.INSTANCE.player().motionY = 0.499900005422085D;
		}
	}

}
