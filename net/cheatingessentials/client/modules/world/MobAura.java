package net.cheatingessentials.client.modules.world;

import java.util.UUID;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.util.EntityUtils;
import net.cheatingessentials.util.Watcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class MobAura extends Module {

	public MobAura() {
		super(Category.WORLD);
		super.setTick(true);
	}
	
	public String getModuleName(){
		return "Auto Hit";
	}

	public String showHelp(){
		return "Hit mobs automatically!";
	}
	
	@Override
	public void tick(){
		for (int i = 0; i < minecraft().theWorld.loadedEntityList.size(); i++)
        {
            Entity ent = (Entity) minecraft().theWorld.loadedEntityList.get(i);
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

            if ((ent == minecraft().thePlayer) || !(ent instanceof EntityLiving) || ent.isDead)
            {
                continue;
            }

            if ((player().getDistanceSqToEntity(ent) <= 15.0D) && !ent.isDead && minecraft().thePlayer.canEntityBeSeen(ent))
            {
            	minecraft().playerController.attackEntity(player(), ent);
            	player().swingItem();
            }
        } 
	}
}
