package common.kodehawa.ce.module.classes;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;

import org.lwjgl.opengl.GL11;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.AltAxisAlignedBB;
import common.kodehawa.ce.util.GLHelper;

public class AnimalESP extends AbstractModule {

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
	            if (o instanceof EntityAnimal) {
	            	final EntityLivingBase living = (EntityLivingBase)o;
	            	double x = living.lastTickPosX + (living.posX - living.lastTickPosX);
					double y = living.lastTickPosY + (living.posY - living.lastTickPosY);
					double z = living.lastTickPosZ + (living.posZ - living.lastTickPosZ);
	                GL11.glPushMatrix();
	                GL11.glTranslated(x, y, z);
	                GL11.glColor3f(1, 1, 0);
	                AltAxisAlignedBB boundingBox = AltAxisAlignedBB.getBoundingBox(0, 0, 0, 1, 2, 1);
                	GL11.glColor4f(1, 1, 0, 0.1F);
                	GLHelper.startDrawingESPs(boundingBox, 0.3F, 0.8F, 1.0F);;
	                GL11.glPopMatrix();
	            }
	        }
		}
	}
}
