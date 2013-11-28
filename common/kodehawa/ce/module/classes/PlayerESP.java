package common.kodehawa.ce.module.classes;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.opengl.GL11;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.AltAxisAlignedBB;
import common.kodehawa.ce.util.CrashManager;
import common.kodehawa.ce.util.EntitySpectator;
import common.kodehawa.ce.util.GLHelper;

public class PlayerESP extends AbstractModule 
{
	
	public PlayerESP() 
	{
		super(Category.RENDER);
		super.setRender(true);
	}
	
	public String getModuleName()
	{
		return "Player ESP";
	}

	public void enable()
	{
		player().addChatMessage("CE PlayerESP. Now with added bugs for extra game experience!");
	}
	
	public void doRender()
	{
		for(Object o : world().loadedEntityList){
			if(o instanceof EntityPlayer){
				EntityPlayer entityplayer = (EntityPlayer)o;
				if(!(entityplayer instanceof EntitySpectator) && !(entityplayer instanceof EntityClientPlayerMP)){
					AltAxisAlignedBB abb = AltAxisAlignedBB.getBoundingBox(1, (double)entityplayer.yOffset, 1, (double)entityplayer.yOffset, 2, 1);
				    double x = entityplayer.lastTickPosX + (entityplayer.posX - entityplayer.lastTickPosX) - RenderManager.renderPosX - 0.5;
					double y = entityplayer.lastTickPosY + (entityplayer.posY - entityplayer.lastTickPosY) - RenderManager.renderPosY;
					double z = entityplayer.lastTickPosZ + (entityplayer.posZ - entityplayer.lastTickPosZ) - RenderManager.renderPosZ - 0.5;
					GL11.glPushMatrix();
		            GL11.glTranslated(x, y, z);
		        	GL11.glColor4f(0.27F, 0.70F, 0.92F, 1.0F);
					GLHelper.startDrawingESPs(abb, 0.27F, 0.70F, 0.92F);
		            GL11.glPopMatrix();
				}
			}
		}
	}
}