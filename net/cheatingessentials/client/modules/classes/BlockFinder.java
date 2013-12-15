package net.cheatingessentials.client.modules.classes;

import java.util.concurrent.CopyOnWriteArrayList;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.util.CEBlockCoord;
import net.cheatingessentials.util.GLHelper;

import org.lwjgl.input.Keyboard;

public class BlockFinder extends Module {

	public BlockFinder() {
		super(Category.RENDER);
		super.setRender(true);
		this.setKeybinding(Keyboard.KEY_NUMPAD1);
	}
	
	private int size = 0, timer = 0;

	public static CopyOnWriteArrayList<Integer> espList = new CopyOnWriteArrayList<Integer>();
	public static CEBlockCoord[] espBlocks = new CEBlockCoord[10000000];
	public static int BLOCK_RADIUS = 55; 
	
	@Override
	public String getModuleName(){
		return "Block Finder";
	}
	
	@Override
	public String showHelp(){
		return "Allows to the player to find a specific kind of block easily when added to a list (55 block radius)";
	}
	
	@Override
	public void doRender(){
		timer++;
		if(timer >= 35){
			refresh();
			timer = 0;
		}
		
		for(int cur = 0; cur < size; cur++) {
			CEBlockCoord curBlock = espBlocks[cur];
			GLHelper.startDrawingESPs(curBlock.getDeltaX(), curBlock.getDeltaY(), curBlock.getDeltaZ(), 0.0F, 0.0F, 1.0F);
		}
	}
	
	public void refresh(){
		size = 0;
		int radius = BLOCK_RADIUS;
		for(int y = 0; y < 128; y++) {
			for(int x = 0; x < radius; x++) {
			for(int z = 0; z < radius; z++) {
				int cX = (int)minecraft().thePlayer.posX - (int)radius/2+x;
				int cY = y;
				int cZ = (int)minecraft().thePlayer.posZ - (int)radius/2+z;
				int ids = world().getBlockId(cX, cY, cZ);
				if (espList.contains(ids)) {
					espBlocks[size++] = new CEBlockCoord(cX, cY, cZ);
				}
			}
		}
	}
}
}