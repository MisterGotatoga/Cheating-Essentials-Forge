package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.client.renderer.entity.RenderManager;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;

public class MobHitbox extends Mod {

	public ModuleCategories getCategory()
	{
		return ModuleCategories.MISC;
	}

	@Override
	public String getName(){
		return "Mob Hitbox";
	}
	
	@Override
	public void onEnableMod(){
		RenderManager.field_85095_o = true;
	}
	
	@Override
	public void onDisableMod(){
		RenderManager.field_85095_o = false;
	}
}
