package net.cheatingessentials.client.modules.render;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.util.AltAxisAlignedBB;
import net.cheatingessentials.util.GLHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.AxisAlignedBB;

import org.lwjgl.opengl.GL11;

public class AnimalESP extends Module {

	public AnimalESP() {
		super(Category.RENDER);
		super.setRender(true);
	}

	@Override
	public String getModuleName(){
		return "Entity Finder";
	}
	
	@Override
	public void doRender(){
		if(isActive()){
			for (Object o : world().loadedEntityList) {
	            if (o instanceof EntityAnimal) 
	            {
	            	final EntityLivingBase living = (EntityLivingBase)o;
					//AltAxisAlignedBB abb = AltAxisAlignedBB.getBoundingBox(living., (double)living.yOffset, 1, (double)living.yOffset, 2, 1);
					double renderX = living.lastTickPosX + (living.posX - living.lastTickPosX) - RenderManager.renderPosX - 0.5;
					double renderY = living.lastTickPosY + (living.posY - living.lastTickPosY);
					double renderZ = living.lastTickPosZ + (living.posZ - living.lastTickPosZ) - RenderManager.renderPosX - 0.5;
					GL11.glPushMatrix();
	                GL11.glTranslated(renderX, renderY, renderZ);
	        	    GL11.glColor4f(0.27F, 0.70F, 0.92F, 1.0F);
					//GLHelper.startDrawingESPs(abb, 0.27F, 0.70F, 0.92F);
	                GL11.glPopMatrix();
	            }
	        }
		}
	}
}
