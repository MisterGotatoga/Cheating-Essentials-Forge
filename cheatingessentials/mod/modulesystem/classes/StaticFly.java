package cheatingessentials.mod.modulesystem.classes;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.util.reflect.ReflectionHelper;
import cheatingessentials.mod.wrapper.Wrapper;

public class StaticFly extends Mod 
{
	
	@Override
	public String getName()
	{
		return "Fly";
	}
	
	@Override
	public int getKeybind()
	{
		return Keyboard.KEY_F;
	}
	
	@Override
	public String getDescription()
	{
		return "Fly like a bird";
	}
	
	@Override
	public boolean playerUpdate()
	{
		return true;
	}
	
	@Override
	public void onPlayerUpdate()
	{
		
		Object o = Wrapper.INSTANCE.player();
		Wrapper.INSTANCE.player().jumpMovementFactor = 0.5F;
		ReflectionHelper.setField(Wrapper.INSTANCE.player().getClass(), o, "landMovementFactor", 0.5F);
		Wrapper.INSTANCE.player().jumpMovementFactor *= 3;

		if(Keyboard.isKeyDown(Wrapper.INSTANCE.mcSettings().keyBindJump.func_151463_i()))
		{
			Wrapper.INSTANCE.player().motionY += 1;
		}
		if(Keyboard.isKeyDown(Wrapper.INSTANCE.mcSettings().keyBindSneak.func_151463_i()))
		{
			Wrapper.INSTANCE.player().motionY -= 1;
		}
		
		Wrapper.INSTANCE.player().motionX = 0;
		Wrapper.INSTANCE.player().motionZ = 0;

	}
}
