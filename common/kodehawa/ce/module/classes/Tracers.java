package common.kodehawa.ce.module.classes;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.opengl.GL11;

import common.kodehawa.ce.config.ConfigurationManager;
import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;

public class Tracers extends AbstractModule {

	public Tracers() {
		super(Category.RENDER);
		super.setRender(true);
	}

	public String getModuleName(){
		return "Tracers";
	}
	
	@Override
	public String showHelp(){
		return "Traces a line to the players in MP";
	}
	
	@Override
	public void doRender(){
		try{
			GL11.glPushMatrix();
            GL11.glEnable(GL11.GL_LINE_SMOOTH);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDepthMask(false);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glLineWidth(1.5F);
            for(Object entities: minecraft().theWorld.loadedEntityList){
            	if (entities != minecraft().thePlayer && entities != null){
            		if (entities instanceof EntityPlayer){ //Add EntityMob also if you want to lol.
            			EntityPlayer entity = (EntityPlayer)entities;
                        float distance = minecraft().renderViewEntity.getDistanceToEntity(entity);
                        double posX = ((entity.lastTickPosX + (entity.posX - entity.lastTickPosX) - RenderManager.instance.renderPosX));
                        double posY = ((entity.lastTickPosY + 1.4 + (entity.posY - entity.lastTickPosY) - RenderManager.instance.renderPosY));
                        double posZ = ((entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) - RenderManager.instance.renderPosZ));
                        if(ConfigurationManager.instance().friends.contains(entity.username)){
                        	GL11.glColor3f(0.0F, 1.0F, 0.0F);
                        if(ConfigurationManager.instance().enemies.contains(entity.username)){
                        	GL11.glColor3f(1.0F, 0.0F, 0.0F);
                        	}
                        }
                        else{
                        	if (distance <= 6F){
                        		GL11.glColor3f(1.0F, 0.0F, 0.0F);
                            }
                        	else if (distance <= 96F){
                        		GL11.glColor3f(1.0F, (distance / 100F), 0.0F);
                        	}
                        	else if (distance > 96F){
                        		GL11.glColor3f(0.1F, 0.6F, 255.0F);
                            }
                       }
                       GL11.glBegin(GL11.GL_LINE_LOOP);
                       GL11.glVertex3d(0, 0, 0);
                       GL11.glVertex3d(posX, posY, posZ);
                       GL11.glEnd();
            		}
            	}
          }
            
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDepthMask(true);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glDisable(GL11.GL_LINE_SMOOTH);
            GL11.glPopMatrix();
            
		}
		catch(Exception e){}
	}
}