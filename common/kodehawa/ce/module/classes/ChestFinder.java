package common.kodehawa.ce.module.classes;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntityChest;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.AltAxisAlignedBB;
import common.kodehawa.ce.util.GLHelper;

public class ChestFinder extends AbstractModule {
	
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
		return "Allows to the player to localize chests easily (128 blocks radius)";
	}
	
	private int size = 0, timer = 0;
	
	@Override
	public void doRender(){
		
		/**
		 * @author Halalaboos / Huzuni Client
		 */
		for (Object o : world().loadedTileEntityList) {
            if (o instanceof TileEntityChest) {
                final TileEntityChest chest = (TileEntityChest) o;
                final double renderX = chest.xCoord - RenderManager.renderPosX;
                final double renderY = chest.yCoord - RenderManager.renderPosY;
                final double renderZ = chest.zCoord - RenderManager.renderPosZ;
                GL11.glPushMatrix();
                GL11.glTranslated(renderX, renderY, renderZ);
                GL11.glColor3f(1, 1, 0);

                if (chest.adjacentChestXPos != null) {
                	AltAxisAlignedBB boundingBox = AltAxisAlignedBB.getBoundingBox(0, 0, 0, 2, 1, 1);
                    GL11.glColor4f(1, 1, 0, 0.1F);
                	GLHelper.startDrawingESPs(boundingBox, 0.3F, 0.8F, 1.0F);;
                } else if (chest.adjacentChestZPosition != null) {
                    AltAxisAlignedBB boundingBox = AltAxisAlignedBB.getBoundingBox(0, 0, 0, 1, 1, 2);
                	GL11.glColor4f(1, 1, 0, 0.1F);
                	GLHelper.startDrawingESPs(boundingBox, 0.3F, 0.8F, 1.0F);;
                } else if (chest.adjacentChestXPos == null && chest.adjacentChestZPosition == null && chest.adjacentChestXNeg == null && chest.adjacentChestZNeg == null) {
                    AltAxisAlignedBB boundingBox = AltAxisAlignedBB.getBoundingBox(0, 0, 0, 1, 1, 1);
                	GL11.glColor4f(1, 1, 0, 0.1F);
                	GLHelper.startDrawingESPs(boundingBox, 0.3F, 0.8F, 1.0F);;
                }
                
                GL11.glPopMatrix();
            }
        }
	}
}
