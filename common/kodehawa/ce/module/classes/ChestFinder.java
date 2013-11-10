package common.kodehawa.ce.module.classes;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.Lists;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.util.CEBlockCoord;
import common.kodehawa.ce.util.GLHelper;
import common.kodehawa.reeszrbteam.ce.util.CEUtils;

public class ChestFinder extends AbstractModule {

	public static List<Integer> cList = Lists.newArrayList();
	public static CEBlockCoord[] cBlocks = new CEBlockCoord[10000000];
	public static int BLOCK_RADIUS = 128; 
	
	public ChestFinder() {
		super(Category.RENDER);
		super.setRender(true);
		this.setKeybinding(Keyboard.KEY_N);
		cList.add(Block.chest.blockID);
		cList.add(Block.enderChest.blockID);
		cList.add(Block.chestTrapped.blockID);
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
		timer++;
		if(timer >= 30){
			refresh();
			timer = 0;
		}
		
		for(int cur = 0; cur < size; cur++)
		{
			CEBlockCoord curBlock = cBlocks[cur];
			GLHelper.startDrawingESPs(curBlock.getDeltaX(), curBlock.getDeltaY(), curBlock.getDeltaZ(), 1.5F, 0.8F, 1.0F);
		}
	}
	
	public void refresh(){
		size = 0;
		int radius = BLOCK_RADIUS;
		for(int y = 0; y < 128; y++) {
			for(int x = 0; x < radius; x++) {
			for(int z = 0; z < radius; z++) {
				int cX = (int)player().posX - (int)radius/2+x;
				int cY = y;
				int cZ = (int)player().posZ - (int)radius/2+z;
				int ids = world().getBlockId(cX, cY, cZ);
				if (cList.contains(ids)) {
					cBlocks[size++] = new CEBlockCoord(cX, cY, cZ);
				}
			}
		}
	}
}
}
