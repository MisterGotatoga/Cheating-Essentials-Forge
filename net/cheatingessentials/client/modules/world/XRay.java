package net.cheatingessentials.client.modules.world;

import java.lang.reflect.Field;
import java.util.concurrent.CopyOnWriteArrayList;

import net.cheatingessentials.api.APIModule;
import net.cheatingessentials.api.Module;
import net.cheatingessentials.client.modules.general.Category;
import net.cheatingessentials.client.modules.general.ModuleManager;
import net.cheatingessentials.util.Utils;
import net.minecraft.block.Block;

import org.lwjgl.input.Keyboard;

public class XRay extends Module
{

	public static CopyOnWriteArrayList<Integer> xrayList2 = new CopyOnWriteArrayList<Integer>();
	
	public XRay() 
	{
		super(Category.WORLD);
		this.setKeybinding(Keyboard.KEY_X);
		/*xrayList2.add(Block.oreCoal.blockID);
		xrayList2.add(Block.oreIron.blockID);
		xrayList2.add(Block.oreGold.blockID);
		xrayList2.add(Block.oreEmerald.blockID);
		xrayList2.add(Block.oreDiamond.blockID);
		xrayList2.add(Block.oreLapis.blockID);
		xrayList2.add(Block.oreRedstone.blockID);
		xrayList2.add(Block.oreRedstoneGlowing.blockID);
		xrayList2.add(Block.oreNetherQuartz.blockID);*/
	}

	@Override
	public String getModuleName()
	{
		return "X-Ray";
	}
	
	@Override
	public void enable()
	{
		if(!APIModule.instance().getModuleClass(Fullbright.class).isActive())
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
		if(!APIModule.instance().getModuleClass(Fullbright.class).isActive())
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
	
	public String showHelp(){
		return "Shows the hidden ores :D";
	}
	
	public static void addDefaultList()
	{
		Utils.instance().removeDupes(xrayList2);
		try
		{
			Field field = Block.class.getDeclaredField("xrayList");
			field.setAccessible(true);
			CopyOnWriteArrayList<Integer> xray = (CopyOnWriteArrayList<Integer>) field.get(null);
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
			CopyOnWriteArrayList<Integer> xray = (CopyOnWriteArrayList<Integer>) field.get(null);
			for(Integer i : xrayList2)
			{
				xray.remove(xrayList2.indexOf((Integer)i)); break;
			}
		} 
		catch (Exception e){
			e.printStackTrace();
		}
	}

	private void rerender()
	{
		minecraft().renderGlobal.loadRenderers();
	}
}