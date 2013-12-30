package net.cheatingessentials.client.modules.render;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.util.AltAxisAlignedBB;
import net.cheatingessentials.util.GLHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class ChestFinder extends Module {
	
	public ChestFinder() {
		super(Category.RENDER);
		super.setRender(true);
		this.setKeybinding(Keyboard.KEY_N);
	}

	@Override
	public String getModuleName(){
		return "Chest Finder";
	}
	
	@Override
	public String showHelp(){
		return "Allows to the player to localize chests easily";
	}
	
	private int size = 0, timer = 0;
	
	@Override
	public void doRender(){
		
		/**
		 * @author Halalaboos / Huzuni Client
		 */
		for (Object o : world().field_147482_g) {
            if (o instanceof TileEntityChest) {
                final TileEntityChest chest = (TileEntityChest) o;
                final double renderX = chest.field_145851_c - RenderManager.renderPosX;
                final double renderY = chest.field_145848_d - RenderManager.renderPosY;
                final double renderZ = chest.field_145849_e - RenderManager.renderPosZ;
                GL11.glPushMatrix();
                GL11.glTranslated(renderX, renderY, renderZ);
                GL11.glColor3f(1, 1, 0);

                if (chest.field_145988_l != null) {
                	AltAxisAlignedBB boundingBox = AltAxisAlignedBB.getBoundingBox(0, 0, 0, 2, 1, 1);
                    GL11.glColor4f(1, 1, 0, 0.1F);
                	GLHelper.startDrawingESPs(boundingBox, 0.3F, 0.8F, 1.0F);
                } else if (chest.field_145990_j != null) {
                    AltAxisAlignedBB boundingBox = AltAxisAlignedBB.getBoundingBox(0, 0, 0, 1, 1, 2);
                	GL11.glColor4f(1, 1, 0, 0.1F);
                	GLHelper.startDrawingESPs(boundingBox, 0.3F, 0.8F, 1.0F);
                } else if (chest.field_145988_l == null && chest.field_145990_j == null && chest.field_145991_k == null && chest.field_145992_i == null) {
                    AltAxisAlignedBB boundingBox = AltAxisAlignedBB.getBoundingBox(0, 0, 0, 1, 1, 1);
                	GL11.glColor4f(1, 1, 0, 0.1F);
                	GLHelper.startDrawingESPs(boundingBox, 0.3F, 0.8F, 1.0F);
                }

                GL11.glPopMatrix();
            }
        }
	}
}
