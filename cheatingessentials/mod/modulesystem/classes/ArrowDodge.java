package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.entity.projectile.EntityArrow;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class ArrowDodge extends Mod {
	
	public String getName()
	{
		return "Arrow Dodge";
	}
	
	public String getDescription()
	{
		return "Say bye to the arrows!";
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.WORLD;
	}
	
	public void onPlayerUpdate()
	{
		try{
			for(Object o: Wrapper.INSTANCE.world().loadedEntityList){
				if(o instanceof EntityArrow){
					EntityArrow e = (EntityArrow)o;
					if(Wrapper.INSTANCE.player().canEntityBeSeen(e) && Wrapper.INSTANCE.player().getDistanceSqToEntity(e) <= 5 && !e.isCollided && !e.onGround){
						Wrapper.INSTANCE.player().motionX = 0.5D;
					}
				}
			}
		}
		catch(Exception ignored){}
	}

}
