package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.util.reflect.ReflectionHelper;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class NoWeb extends Mod {

	public NoWeb()
	{
		this.setCategory(ModuleCategories.PLAYER);
	}
	
	@Override
	public String getName(){
		return "No Web";
	}
	
	@Override
	public String getDescription(){
		return "No more webs annoying you! Removes web slowdown";
	}
	
	@Override
	public void onTick(){
		Object o = Wrapper.INSTANCE.player();
		if(o instanceof EntityPlayerSP){
			ReflectionHelper.setField(Entity.class, o, "isInWeb", false);
		}
	}
}
