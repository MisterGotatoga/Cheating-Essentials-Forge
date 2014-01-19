package cheatingessentials.mod.modulesystem.classes;

import net.minecraft.tileentity.TileEntityChest;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;

public class ChestFinder extends Mod {
	
	public ChestFinder()
	{
		this.setKeybinding(Keyboard.KEY_N);
		this.setCategory(ModuleCategories.RENDER);
	}
	
	@Override
	public String getName(){
		return "Chest Finder";
	}
	
	@Override
	public String getDescription(){
		return "Allows to the player to localize chests easily";
	}
		
	@Override
	public void onWorldRender(){
		
		/**
		 * @author Halalaboos / Huzuni Client
		 */
		for (Object o : Wrapper.INSTANCE.world().field_147482_g) {
            if (o instanceof TileEntityChest) {
                /*final TileEntityChest chest = (TileEntityChest) o;
                final double renderX = chest.xCoord - RenderManager.renderPosX;
                final double renderY = chest.yCoord - RenderManager.renderPosY;
                final double renderZ = chest.zCoord - RenderManager.renderPosZ;
                GL11.glPushMatrix();
                GL11.glTranslated(renderX, renderY, renderZ);
                GL11.glColor3f(1, 1, 0);

                if (chest.adjacentChestXPos != null) {
                	AltAxisAlignedBB boundingBox = AltAxisAlignedBB.getBoundingBox(0, 0, 0, 2, 1, 1);
                    GL11.glColor4f(1, 1, 0, 0.1F);
                	GLHelper.startDrawingESPs(boundingBox, 0.3F, 0.8F, 1.0F);
                } else if (chest.adjacentChestZPosition != null) {
                    AltAxisAlignedBB boundingBox = AltAxisAlignedBB.getBoundingBox(0, 0, 0, 1, 1, 2);
                	GL11.glColor4f(1, 1, 0, 0.1F);
                	GLHelper.startDrawingESPs(boundingBox, 0.3F, 0.8F, 1.0F);
                } else if (chest.adjacentChestXPos == null && chest.adjacentChestZPosition == null && chest.adjacentChestXNeg == null && chest.adjacentChestZNeg == null) {
                    AltAxisAlignedBB boundingBox = AltAxisAlignedBB.getBoundingBox(0, 0, 0, 1, 1, 1);
                	GL11.glColor4f(1, 1, 0, 0.1F);
                	GLHelper.startDrawingESPs(boundingBox, 0.3F, 0.8F, 1.0F);
                }*/

                GL11.glPopMatrix();
            }
        }
	}
}
