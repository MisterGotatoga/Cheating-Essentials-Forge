package cheatingessentials.mod.modulesystem.classes;

import java.util.concurrent.CopyOnWriteArrayList;

import net.minecraft.block.Block;
import cheatingessentials.api.module.Mod;
import cheatingessentials.mod.internal.CEBlockCoord;
import cheatingessentials.mod.util.GLUtils;
import cheatingessentials.mod.wrapper.ModuleCategories;
import cheatingessentials.mod.wrapper.Wrapper;
import cpw.mods.fml.common.registry.GameData;

public class BlockFinder extends Mod {

	public BlockFinder() 
	{
		instance = this;
	}

	public ModuleCategories getCategory()
	{
		return ModuleCategories.RENDER;
	}
	
	private int size = 0, timer = 0;
	
	public static BlockFinder instance;

	public static CopyOnWriteArrayList<Integer> idEspList = new CopyOnWriteArrayList<Integer>();
	public static CopyOnWriteArrayList<Long> metaEspList = new CopyOnWriteArrayList<Long>();
	public static CEBlockCoord[] espBlocks = new CEBlockCoord[10000000];
	public static int BLOCK_RADIUS = 55; 
	
	@Override
	public String getName(){
		return "Block Finder";
	}
	
	@Override
	public String getDescription(){
		return "Allows to the player to find a specific kind of block easily when added to a list (55 block radius)";
	}
	
	
	
	@Override
	public void onWorldRender(){
		timer++;
		if(timer >= 35){
			refresh();
			timer = 0;
		}
		
		for(int cur = 0; cur < size; cur++) {
			CEBlockCoord curBlock = espBlocks[cur];
			GLUtils.startDrawingESPs(curBlock.getDeltaX(), curBlock.getDeltaY(), curBlock.getDeltaZ(), 0.0F, 0.0F, 1.0F);
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
				int cX = (int)Wrapper.INSTANCE.minecraft().thePlayer.posX - (int)radius/2+x;
				int cY = y;
				int cZ = (int)Wrapper.INSTANCE.minecraft().thePlayer.posZ - (int)radius/2+z;
				Block blockpos = Wrapper.INSTANCE.world().func_147439_a(cX, cY, cZ);
				int ids = GameData.blockRegistry.getId(blockpos);
				if (idEspList.contains(ids)) {
					espBlocks[size++] = new CEBlockCoord(cX, cY, cZ);
				}else{
					int meta = Wrapper.INSTANCE.world().getBlockMetadata(cX, cY, cZ);
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