package net.cheatingessentials.client.modules.util;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.minecraft.client.renderer.entity.RenderManager;

public class MobHitbox extends Module {

	public MobHitbox() {
		super(Category.UTILS);
	}

	@Override
	public String getModuleName(){
		return "Mob Hitbox";
	}
	
	@Override
	public void enable(){
		RenderManager.field_85095_o = true;
	}
	
	@Override
	public void disable(){
		RenderManager.field_85095_o = false;
	}
}
