package common.kodehawa.ce.module.classes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;

import net.minecraft.block.Block;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.Lists;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.module.man.ModuleManager;
import common.kodehawa.ce.util.Utils;

public class XRay extends AbstractModule
{

	public static ArrayList<Integer> xrayList2 = Lists.newArrayList();
	
	public XRay() 
	{
		super(Category.RENDER);
		this.setKeybinding(Keyboard.KEY_X);
		addDefaultBlocks();
	}

	@Override
	public String getModuleName()
	{
		return "X-Ray";
	}
	
	@Override
	public void enable()
	{
		if(!ModuleManager.instance().getModuleClass(Fullbright.class).isActive())
		{
			float[] bright = world().provider.lightBrightnessTable;
			for(int i = 0; i < bright.length; i++){
				bright[i] = 1.0F;
			}
		}
		rerender();
		try
		{
			Field field = Block.class.getDeclaredField("enabled");
			if(field != null){
				field.setAccessible(true);
				field.setBoolean(null, true);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		addDefaultList();
	}
	
	@Override
	public void disable()
	{
		if(!ModuleManager.instance().getModuleClass(Fullbright.class).isActive())
		{
			world().provider.registerWorld(world());
		}
		rerender();
		try
		{
			Field field = Block.class.getDeclaredField("enabled");
			if(field != null){
				field.setAccessible(true);
				field.setBoolean(null, false);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void addDefaultBlocks(){
		xrayList2.add(Block.oreCoal.blockID);
		xrayList2.add(Block.oreIron.blockID);
		xrayList2.add(Block.oreGold.blockID);
		xrayList2.add(Block.oreEmerald.blockID);
		xrayList2.add(Block.oreDiamond.blockID);
		xrayList2.add(Block.oreLapis.blockID);
		xrayList2.add(Block.oreRedstone.blockID);
		xrayList2.add(Block.oreRedstoneGlowing.blockID);
		xrayList2.add(Block.oreNetherQuartz.blockID);
	}
	
	public static void addDefaultList()
	{
		Utils.instance().removeDupes(xrayList2);
		try
		{
			Field field = Block.class.getDeclaredField("xrayList");
			field.setAccessible(true);
			ArrayList<Integer> xray = (ArrayList<Integer>) field.get(null);
			addDefaultBlocks();
			for(Integer i : xrayList2)
			{
				Utils.instance().removeDupes(xray);
				xray.add(i);
			}
		} 
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void removeDefaultList()
	{
		Utils.instance().removeDupes(xrayList2);
		try
		{
			Field field = Block.class.getDeclaredField("xrayList");
			field.setAccessible(true);
			ArrayList<Integer> xray = (ArrayList<Integer>) field.get(null);
			for(Integer i : xrayList2)
			{
				xray.remove(i);
			}
		} 
		catch (Exception e){
			e.printStackTrace();
		}
	}

	private void rerender()
	{
		int x = (int) player().posX;
		int y = (int) player().posY;
		int z = (int) player().posZ;
		minecraft().renderGlobal.markBlockRangeForRenderUpdate(x - 200, y - 200, z - 200, x + 200, y + 200, z + 200);
	}
}