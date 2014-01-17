package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.oredict.RecipeSorter.Category;

import org.lwjgl.opengl.GL11;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.external.axis.AltAxisAlignedBB;
import cheatingessentials.mod.internal.FreecamEntity;
import cheatingessentials.mod.util.GLUtils;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class PlayerESP extends Mod 
{
	
	public String getName()
	{
		return "Player ESP";
	}
	
	public ModuleCategories getCategory()
	{
		return ModuleCategories.RENDER;
	}

	public void onEnableMod()
	{
		Wrapper.INSTANCE.addChatMessage("CE PlayerESP. Now with added bugs for extra game experience!");
	}
	
	public void onWorldRender()
	{
		for(Object o : Wrapper.INSTANCE.world().loadedEntityList){
			if(o instanceof EntityPlayer){
				EntityPlayer entityplayer = (EntityPlayer)o;
				if(!(entityplayer instanceof FreecamEntity) && !(entityplayer instanceof EntityClientPlayerMP)){
					AltAxisAlignedBB abb = AltAxisAlignedBB.getBoundingBox(1, (double)entityplayer.yOffset, 1, (double)entityplayer.yOffset, 2, 1);
				    double x = entityplayer.lastTickPosX + (entityplayer.posX - entityplayer.lastTickPosX) - RenderManager.renderPosX - 0.5;
					double y = entityplayer.lastTickPosY + (entityplayer.posY - entityplayer.lastTickPosY) - RenderManager.renderPosY;
					double z = entityplayer.lastTickPosZ + (entityplayer.posZ - entityplayer.lastTickPosZ) - RenderManager.renderPosZ - 0.5;
					GL11.glPushMatrix();
		            GL11.glTranslated(x, y, z);
		        	GL11.glColor4f(0.27F, 0.70F, 0.92F, 1.0F);
					GLUtils.startDrawingESPs(abb, 0.27F, 0.70F, 0.92F);
		            GL11.glPopMatrix();
				}
			}
		}
	}
}