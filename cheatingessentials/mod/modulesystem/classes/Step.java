package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.entity.Entity;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.util.reflect.ReflectionHelper;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class Step extends Mod {

	
	public static float DEFAULT_STEP_HEIGHT = 1.0F;
	
	public Step()
	{
		super(ModuleCategories.MOVEMENT);
	}
	
	@Override
	public String getName(){
		return "Step";
	}

	@Override
	public String getDescription(){
		return "Makes the player takes a entire block or more blocks as a slab, for jump automatically";
	}
	
	@Override
	public void onTick(){
		Object o = Wrapper.INSTANCE.player();
		ReflectionHelper.setField(Entity.class, o, 42, DEFAULT_STEP_HEIGHT);
	}
}
