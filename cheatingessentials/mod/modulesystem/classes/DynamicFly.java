package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.input.Keyboard;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.util.reflect.ReflectionHelper;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class DynamicFly extends Mod {

	public DynamicFly()
	{
		super(ModuleCategories.PLAYER);
		this.setKeybinding(Keyboard.KEY_H);
	}
	
	@Override
	public String getName(){
		return "Dynamic Fly";
	}
	
	@Override
	public String getDescription(){
		return "Another way to fly. Also called static fly";
	}
	
	@Override 
	public void onPlayerUpdate(){
		Object o = Wrapper.INSTANCE.player();
		Wrapper.INSTANCE.player().jumpMovementFactor = 0.4F;
		ReflectionHelper.setField(EntityLivingBase.class, o, 56, 0.4F);
		Wrapper.INSTANCE.player().motionX = 0;
		Wrapper.INSTANCE.player().motionY = 0;
		Wrapper.INSTANCE.player().motionZ = 0;
		Wrapper.INSTANCE.player().jumpMovementFactor *= 3;
		
		if(Keyboard.isKeyDown(Wrapper.INSTANCE.minecraft().gameSettings.keyBindJump.func_151463_i())){
			Wrapper.INSTANCE.player().motionY += 1;
		}
		if(Keyboard.isKeyDown(Wrapper.INSTANCE.minecraft().gameSettings.keyBindSneak.func_151463_i())){
			Wrapper.INSTANCE.player().motionY -= 1;
		}
	}
}
