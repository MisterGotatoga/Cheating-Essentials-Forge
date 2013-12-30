package net.cheatingessentials.client.modules.render;

import java.util.concurrent.CopyOnWriteArrayList;

import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.util.CEBlockCoord;
import net.cheatingessentials.util.GLHelper;
import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockFinder extends Module {

	public BlockFinder() {
		super(Category.RENDER);
		super.setRender(true);
		this.setKeybinding(Keyboard.KEY_NUMPAD1);
		instance = this;
	}
	
	private int size = 0, timer = 0;
	
	public static BlockFinder instance;

	public CopyOnWriteArrayList<Integer> idEspList = new CopyOnWriteArrayList<Integer>();
	public CopyOnWriteArrayList<Long> metaEspList = new CopyOnWriteArrayList<Long>();
	public CEBlockCoord[] espBlocks = new CEBlockCoord[10000000];
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
	
	public void addBlock(int id){
		idEspList.add(id);
	}
	
	public void addBlock(int id, int meta){
		long block = mergedId(id, meta);
		metaEspList.add(block);
	}
	
	public void removeBlock(int id){
		int index = idEspList.indexOf(id);
		idEspList.remove(index);
	}
	
	public void removeBlock(int id, int meta){
		long block = mergedId(id, meta);
		metaEspList.remove(block);
	}
	
	public void removeAll(){
		idEspList.clear();
		metaEspList.clear();
	}
	
	public String list(){
		String idString = "Esp Blocks: ";
		for (int id : idEspList) {
			idString += System.lineSeparator() + id;
		}
		for (long mergedId : metaEspList) {
			idString += System.lineSeparator() + idFromMerged(mergedId) + ":" + metaFromMergedId(mergedId);
		}
		return idString;
	}
	
	private long mergedId(int id, int meta){
		return (((long)id) << 32) | (meta & 0xffffffffL);
	}
	
	private int idFromMerged(long mergedId){
		return (int)(mergedId >> 32);
	}
	
	private int metaFromMergedId(long mergedId){
		return (int)mergedId;
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
				if (idEspList.contains(ids)) {
					espBlocks[size++] = new CEBlockCoord(cX, cY, cZ);
				}else{
					int meta = world().getBlockMetadata(cX, cY, cZ);
					long block = mergedId(ids, meta);
					if(metaEspList.contains(block)){
						espBlocks[size++] = new CEBlockCoord(cX, cY, cZ);
					}
				}
			}
		}
	}
}
}