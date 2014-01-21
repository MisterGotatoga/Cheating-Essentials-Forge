package cheatingessentials.mod.modulesystem.classes;

import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.util.MathHelper;
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
	
	private float newPitch;
	private float newYaw;
	
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
            	faceEntity(ent);
                Wrapper.INSTANCE.player().sendQueue.func_147258_a(new S08PacketPlayerPosLook(Wrapper.INSTANCE.player().posX, Wrapper.INSTANCE.player().posY, Wrapper.INSTANCE.player().posZ, newYaw, newPitch, Wrapper.INSTANCE.player().onGround));
            	Wrapper.INSTANCE.minecraft().playerController.attackEntity(Wrapper.INSTANCE.player(), ent);
            	Wrapper.INSTANCE.player().swingItem();
            }
        }
	}
	
	public void faceEntity(Entity entity)
	{
		
	    double x = entity.posX - Wrapper.INSTANCE.minecraft().thePlayer.posX;
	    double z = entity.posZ - Wrapper.INSTANCE.minecraft().thePlayer.posZ;
	    double y = entity.posY + (entity.getEyeHeight()/1.2D) - Wrapper.INSTANCE.minecraft().thePlayer.posY + (Wrapper.INSTANCE.minecraft().thePlayer.getEyeHeight()/1.4D);
	    double helper = MathHelper.sqrt_double(x * x + z * z);

	    newYaw = (float)((Math.toDegrees(-Math.atan(x / z))));
	    newPitch = (float)-Math.toDegrees(Math.atan(y / helper));

	    if(z < 0 && x < 0) { newYaw = (float)(90D + Math.toDegrees(Math.atan(z / x))); }
	    else if(z < 0 && x > 0) { newYaw = (float)(-90D + Math.toDegrees(Math.atan(z / x))); }
	}
}
