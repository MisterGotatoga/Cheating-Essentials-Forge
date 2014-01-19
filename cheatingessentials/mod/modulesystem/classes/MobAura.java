package cheatingessentials.mod.modulesystem.classes;

import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.util.EntityUtils;
import cheatingessentials.mod.util.Watcher;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class MobAura extends Mod {
	
	public MobAura()
	{
		super(ModuleCategories.PLAYER);
	}
	
	public String getName(){
		return "Auto Hit";
	}

	public String getDescription(){
		return "Hit mobs automatically!";
	}
	
	@Override
	public void onTick(){
		for (int i = 0; i < Wrapper.INSTANCE.minecraft().theWorld.loadedEntityList.size(); i++)
        {
            Entity ent = (Entity) Wrapper.INSTANCE.minecraft().theWorld.loadedEntityList.get(i);
            UUID id = ent.getUniqueID();
            long now = System.currentTimeMillis();
            Watcher tracked = EntityUtils.getLastAffected(id);

            if (tracked != null)
            {
                if (tracked.matches(ent, now))
                {
                    continue;
                }
            }

            EntityUtils.setLastAffected(id, ent);

            if ((ent == Wrapper.INSTANCE.minecraft().thePlayer) || !(ent instanceof EntityLiving) || ent.isDead)
            {
                continue;
            }

            if ((Wrapper.INSTANCE.player().getDistanceSqToEntity(ent) <= 15.0D) && !ent.isDead && Wrapper.INSTANCE.player().canEntityBeSeen(ent))
            {
            	Wrapper.INSTANCE.minecraft().playerController.attackEntity(Wrapper.INSTANCE.player(), ent);
            	Wrapper.INSTANCE.player().swingItem();
            }
        } 
	}
}
