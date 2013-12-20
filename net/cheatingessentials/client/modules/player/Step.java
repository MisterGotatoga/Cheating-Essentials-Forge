package net.cheatingessentials.client.modules.player;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.util.ReflectionHelper;
import net.minecraft.entity.Entity;

public class Step extends Module {

	public Step() {
		super(Category.PLAYER);
		this.setTick(true);
	}
	
	public static float DEFAULT_STEP_HEIGHT = 1.0F;
	
	@Override
	public String getModuleName(){
		return "Step";
	}

	@Override
	public String showHelp(){
		return "Makes the player takes a entire block or more blocks as a slab, for jump automatically";
	}
	
	@Override
	public void tick(){
		Object o = player();
		ReflectionHelper.setField(Entity.class, o, 42, DEFAULT_STEP_HEIGHT);
	}
}
